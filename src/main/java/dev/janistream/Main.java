package dev.janistream;

import picocli.CommandLine;

@CommandLine.Command(name = "janistream", mixinStandardHelpOptions = true)
public class Main implements Runnable{
    public static void main(String[] args) {
        new CommandLine(new Main()).execute(args);
    }
    public void run(){
        System.out.println("Busca por: " + query);
    }

    @CommandLine.Option(names = "--query")
    String query;
}