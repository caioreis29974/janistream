package dev.janistream;

import dev.janistream.api.JikanClient;
import dev.janistream.model.Anime;
import dev.janistream.model.Episode;
import dev.janistream.ui.TerminalUI;
import picocli.CommandLine;

import java.io.IOException;
import java.util.List;

@CommandLine.Command(name = "janistream", mixinStandardHelpOptions = true)
public class Main implements Runnable{
    public static void main(String[] args) {
        new CommandLine(new Main()).execute(args);
    }
    public void run(){
        try {
            JikanClient jikanClient = new JikanClient();
            List<Anime> animes = jikanClient.search(query);
            TerminalUI terminalUI = new TerminalUI();
            Anime animeSelecionado = terminalUI.selectAnime(animes);
            System.out.println("Você selecionou: " + animeSelecionado.getTitle());

            List<Episode> episodes = jikanClient.getEpisodes(animeSelecionado.getMalId());
            for (Episode episode : episodes){
                System.out.println(episode.getNumber() + " - " + episode.getTitle());
            }
        } catch (IOException e) {
            System.out.println("Erro ao buscar animes: " + e.getMessage());
        }
    }

    @CommandLine.Option(names = "--query")
    String query;
}