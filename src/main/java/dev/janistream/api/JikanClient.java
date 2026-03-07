package dev.janistream.api;


import com.google.gson.Gson;
import dev.janistream.model.Anime;
import dev.janistream.model.JikanResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;

public class JikanClient {

    private final OkHttpClient http;
    private final Gson gson;

    public JikanClient(){
        this.http = new OkHttpClient();
        this.gson = new Gson();
    }

    public List<Anime> search(String query) throws IOException {
        String url = "https://api.jikan.moe/v4/anime?q=" + query + "&limit=10";
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = http.newCall(request).execute();
        if (!response.isSuccessful()){
            throw new IOException("Erro na requisição: " + response.code());
        }
        String json = response.body().string();
        JikanResponse jikanResponse = gson.fromJson(json, JikanResponse.class);
        return jikanResponse.getData();
    }
}
