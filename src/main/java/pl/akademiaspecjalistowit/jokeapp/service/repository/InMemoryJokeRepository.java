package pl.akademiaspecjalistowit.jokeapp.service.repository;

import pl.akademiaspecjalistowit.jokeapp.model.Joke;

import java.util.List;

public class InMemoryJokeRepository implements JokeRepository {

    @Override
    public List<Joke> getAllJoke() {
        return null;
    }

    @Override
    public List<Joke> getAllByCategory(String category) {
        return null;
    }
}
