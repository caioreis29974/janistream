package dev.janistream.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Anime {

    @SerializedName("mal_id")
    private int malId;

    private String title;

    @SerializedName("title_english")
    private String titleEnglish;

    private double score;
    private int episodes;
    private String synopsis;
}
