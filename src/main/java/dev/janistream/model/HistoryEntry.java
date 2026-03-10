package dev.janistream.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HistoryEntry {

    private int id;
    private String animeTitle;
    private int episodeNumber;
    private String episodeTitle;
    private String watchedAt;

}
