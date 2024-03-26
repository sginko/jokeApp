package pl.akademiaspecjalistowit.jokeapp.repository;

import pl.akademiaspecjalistowit.jokeapp.model.Joke;

import java.util.*;


public class InMemoryJokeRepository implements JokeRepository {
    private Map<String, List<Joke>> jokes = jokesInit();

    @Override
    public List<Joke> getAllJokes() {
        return this.jokes.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream())
                .toList();
    }

    @Override
    public List<Joke> getAllByCategory(String category) {
        return this.jokes.entrySet().stream()
                .filter(entry -> entry.getKey().equalsIgnoreCase(category))
                .flatMap(entry -> entry.getValue().stream())
                .toList();
    }

    public Set<String> getAllNamesOfCategories() {
        return jokes.keySet();
    }

    private Map<String, List<Joke>> jokesInit() {
        Map<String, List<Joke>> initializedJokes = new HashMap<>();
        initializedJokes.put("Category 1", List.of(
                new Joke(UUID.randomUUID(), "It's joke one from category 1 from memory"),
                new Joke(UUID.randomUUID(), "It's joke two from category 1 from memory"),
                new Joke(UUID.randomUUID(), "It's joke three from category 1 from memory")
        ));
        initializedJokes.put("Category 2", List.of(
                new Joke(UUID.randomUUID(), "It's joke one from category 2 from memory"),
                new Joke(UUID.randomUUID(), "It's joke two from category 2 from memory")
        ));
        return initializedJokes;
    }
}
