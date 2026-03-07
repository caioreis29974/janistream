package dev.janistream.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Anime {
    private int malId;
    private String title;
    private String titleEnglish;
    private double score;
    private int episodes;
    private String synopsis;
}
