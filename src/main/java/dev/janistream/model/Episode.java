package dev.janistream.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Episode {

    @SerializedName("mal_id")
    private int number;

    private String title;
    private String aired;
}
