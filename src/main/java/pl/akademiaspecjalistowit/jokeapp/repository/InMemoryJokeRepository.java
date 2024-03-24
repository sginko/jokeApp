package pl.akademiaspecjalistowit.jokeapp.repository;

import pl.akademiaspecjalistowit.jokeapp.model.Joke;

import java.util.List;
import java.util.Map;
import java.util.UUID;


public class InMemoryJokeRepository implements JokeRepository {
    private Map<String, List<Joke>> jokes = jokesInit();

//    @Override
//    public List<Joke> getAllJokes() {
//        return this.jokes.get("Category1");
//    }

    @Override
    public List<Joke> getAllJokes() {
        return this.jokes.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream())
                .toList();
    }

    private Map<String, List<Joke>> jokesInit() {
        return Map.of(
                "Category 1", List.of(new Joke(UUID.randomUUID(), "It's joke from memory"))
        );
    }
}
