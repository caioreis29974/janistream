package dev.janistream;

import dev.janistream.api.JikanClient;
import dev.janistream.model.Anime;
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
            for (Anime anime : animes){
                System.out.println(anime.getTitle());
            }
        } catch (IOException e) {
            System.out.println("Erro ao buscar animes: " + e.getMessage());
        }
    }

    @CommandLine.Option(names = "--query")
    String query;
}