package pl.akademiaspecjalistowit.jokeapp.model;

import java.util.UUID;

public class Joke {
    private UUID id;
    private String content;

    public Joke() {
    }

    public String getContent() {
        return content;
    }

    public Joke(UUID id, String content) {
        this.id = id;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Joke{" +
                "content='" + content + '\'' +
                '}';
    }
}
