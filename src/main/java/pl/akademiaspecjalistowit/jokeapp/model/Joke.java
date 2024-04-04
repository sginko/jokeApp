package pl.akademiaspecjalistowit.jokeapp.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class Joke{
    private UUID id;
    private String content;
    private String category;

    private Joke() {
    }

//    public Joke(UUID id, String content) {
//        this.id = id;
//        this.content = content;
//    }

    public Joke(String content, String category) {
        this.id = UUID.randomUUID();
        this.content = content;
        this.category = category;
    }

    public UUID getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joke joke = (Joke) o;
        return Objects.equals(id, joke.id) && Objects.equals(content, joke.content) && Objects.equals(category, joke.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, category);
    }
}
