package pl.akademiaspecjalistowit.jokeapp.repository;

import pl.akademiaspecjalistowit.jokeapp.model.Joke;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


public class InMemoryJokeRepository implements JokeRepository {
    private Map<String, List<Joke>> jokes = jokesInit();

    @Override
    public List<Joke> getAllJokes() {
        return this.jokes.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream())
                .toList();
    }

    private Map<String, List<Joke>> jokesInit() {
        Map<String, List<Joke>> initializedJokes = new HashMap<>();
        initializedJokes.put("Category 1", List.of(
                new Joke(UUID.randomUUID(), "It's joke one from memory"),
                new Joke(UUID.randomUUID(), "It's joke two from memory"),
                new Joke(UUID.randomUUID(), "It's joke three from memory")
        ));
        initializedJokes.put("Category 2", List.of(
                new Joke(UUID.randomUUID(), "It's joke four from memory"),
                new Joke(UUID.randomUUID(), "It's joke five from memory")
        ));
        return initializedJokes;
    }
}
