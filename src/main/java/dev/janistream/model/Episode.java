package dev.janistream.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Episode {
    private int number;
    private String title;
    private String aired;
}
