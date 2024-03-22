package pl.akademiaspecjalistowit.jokeapp.model.domain;

import java.util.UUID;

public class Joke {
    private UUID id;
    private String content;

    public Joke() {
    }

    public String getContent() {
        return "It's funny joke";
    }
}
