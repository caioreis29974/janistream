package dev.janistream.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class JikanResponse {
    private List<Anime> data;
}
