package dev.janistream.ui;

import dev.janistream.model.Anime;
import dev.janistream.model.Episode;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;
import java.util.List;

public class TerminalUI {

    private final Terminal terminal;
    private final LineReader lineReader;

    public TerminalUI() throws IOException {
        this.terminal = TerminalBuilder.builder().system(true).build();
        this.lineReader = LineReaderBuilder.builder().terminal(terminal).build();
    }

    public Anime selectAnime(List<Anime> animes) throws IOException {
        terminal.enterRawMode();

        int selecionado = 0;
        while (true) {
            terminal.writer().print("\033[2J\033[3J\033[H");
            terminal.writer().flush();

            for (int i = 0; i < animes.size(); i++) {
                if (i == selecionado) {
                    terminal.writer().println("❯ " + animes.get(i).getTitle());
                } else {
                    terminal.writer().println("  " + animes.get(i).getTitle());
                }
            }
            terminal.writer().flush();

            int tecla = terminal.reader().read();

            if (tecla == 27) {
                terminal.reader().read(); // lê o [
                int direcao = terminal.reader().read();

                if (direcao == 65) { // seta pra cima
                    selecionado = Math.max(0, selecionado - 1);
                } else if (direcao == 66) { // seta pra baixo
                    selecionado = Math.min(animes.size() - 1, selecionado + 1);
                }
            } else if (tecla == 13) { // Enter
                return animes.get(selecionado);
            }
        }
    }

    public Episode selectEpisode(List<Episode> episodes) throws IOException {
        terminal.enterRawMode();

        int selecionado = 0;
        int visiveis = 15;

        while(true){
            terminal.writer().print("\033[2J\033[3J\033[H");
            terminal.writer().flush();

            int inicio = Math.max(0, selecionado - visiveis / 2);
            int fim = Math.min(episodes.size(), inicio + visiveis);

            for (int i = inicio; i < fim; i++) {
                if (i == selecionado) {
                    terminal.writer().println("❯ " + episodes.get(i).getNumber() + " - " + episodes.get(i).getTitle());
                } else {
                    terminal.writer().println("  " + episodes.get(i).getNumber() + " - " + episodes.get(i).getTitle());
                }
            }
            
            terminal.writer().flush();
            int tecla = terminal.reader().read();

            if (tecla == 27) {
                terminal.reader().read(); // lê o [
                int direcao = terminal.reader().read();

                if (direcao == 65) { // seta pra cima
                    selecionado = Math.max(0, selecionado - 1);
                } else if (direcao == 66) { // seta pra baixo
                    selecionado = Math.min(episodes.size() - 1, selecionado + 1);
                }
            } else if (tecla == 13) { // Enter
                return episodes.get(selecionado);
            }
        }
    }
}
