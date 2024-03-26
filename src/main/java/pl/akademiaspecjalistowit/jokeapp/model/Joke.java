package pl.akademiaspecjalistowit.jokeapp.model;

import java.util.UUID;

public class Joke {
    private UUID id;
    private String content;
    private String category;

    public Joke() {
    }

    public Joke(UUID id, String content) {
        this.id = id;
        this.content = content;
    }

    public Joke(UUID id, String content, String category) {
        this.id = id;
        this.content = content;
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return content;
    }
}
