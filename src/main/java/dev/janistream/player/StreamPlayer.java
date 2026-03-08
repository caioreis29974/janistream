package dev.janistream.player;

import dev.janistream.model.Anime;
import dev.janistream.model.Episode;

import java.io.IOException;

public class StreamPlayer {

    public void play(Anime anime, Episode episode) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder(
                "mpv",
                "--ytdl",
                "--script-opts=ytdl_hook-ytdl_path=yt-dlp",
                "--ytdl-format=bestvideo[height<=1080]+bestaudio/best",
                "ytdl://ytsearch1:" + anime.getTitle() + " episode " + episode.getNumber()
        );

        pb.inheritIO();
        pb.inheritIO();
        Process process = pb.start();
        process.waitFor();

    }

}
