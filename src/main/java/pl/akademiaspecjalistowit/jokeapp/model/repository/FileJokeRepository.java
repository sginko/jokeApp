package pl.akademiaspecjalistowit.jokeapp.model.repository;

import pl.akademiaspecjalistowit.jokeapp.model.domain.Joke;

import java.util.List;

public class FileJokeRepository implements JokeRepository {
    @Override
    public List<Joke> getAllJoke() {
        return null;
    }

    @Override
    public List<Joke> getAllByCategory(String category) {
        return null;
    }
}
