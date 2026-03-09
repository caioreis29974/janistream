package dev.janistream;

import com.github.lalyos.jfiglet.FigletFont;
import dev.janistream.api.JikanClient;
import dev.janistream.model.Anime;
import dev.janistream.model.Episode;
import dev.janistream.player.StreamPlayer;
import dev.janistream.ui.TerminalUI;
import picocli.CommandLine;

import java.io.IOException;
import java.util.List;

@CommandLine.Command(
        name = "janistream",
        mixinStandardHelpOptions = true,
        version = "janistream 1.0.0"
)
public class Main implements Runnable{
    public static void main(String[] args) {

        try {
            if (args.length == 0 || args[0].equals("--help") || args[0].equals("-h") ||
                    args[0].equals("--version") || args[0].equals("-V")) {
                System.out.println(FigletFont.convertOneLine("janistream"));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        new CommandLine(new Main()).execute(args);

    }

    public void run(){
        if (query == null) {
            new CommandLine(this).usage(System.out);
            return;
        }

        try {

            JikanClient jikanClient = new JikanClient();
            List<Anime> animes = jikanClient.search(query);
            TerminalUI terminalUI = new TerminalUI();
            Anime animeSelecionado = terminalUI.selectAnime(animes);
            System.out.println("Você selecionou: " + animeSelecionado.getTitle());

            List<Episode> episodes = jikanClient.getEpisodes(animeSelecionado.getMalId());
            Episode episodioSelecionado = terminalUI.selectEpisode(episodes);
            System.out.println("Você selecionou o episodio: " + episodioSelecionado.getTitle());

            StreamPlayer streamPlayer = new StreamPlayer();
            streamPlayer.play(animeSelecionado, episodioSelecionado);

        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao buscar animes: " + e.getMessage());
        }
    }

    @CommandLine.Option(names = "--query", description = "Search for an anime to stream")
    String query;
}