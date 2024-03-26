package pl.akademiaspecjalistowit.jokeapp.httpclient;

import okhttp3.OkHttpClient;
import pl.akademiaspecjalistowit.jokeapp.model.JokeDto;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class JokeClientService {
    private final JokeClient jokeClient;

    public JokeClientService() {
        OkHttpClient httpClient = new OkHttpClient.Builder().build();
        // You can configure OkHttpClient here if needed (e.g., for authentication)
        this.jokeClient = new Retrofit.Builder()
                .baseUrl("https://v2.jokeapi.dev") // Replace with your API base URL
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build()
                .create(JokeClient.class);
    }

    public JokeDto fetchJokeDto() {
        try {
            Response<JokeDto> execute = jokeClient.getJoke().execute();
            if (execute.code() == 200) {
                return execute.body();
            }
            throw new RuntimeException("Response code is not acceptable");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public JokeDto fetchJokeDtoByCategory(String category) {
        try {
            Response<JokeDto> execute = jokeClient.getJokeByCategory(category).execute();
            if (execute.code() == 200) {
                return execute.body();
            }
            throw new RuntimeException("Response code is not acceptable");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
