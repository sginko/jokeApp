package pl.akademiaspecjalistowit.jokeapp.model.repository;

import pl.akademiaspecjalistowit.jokeapp.model.domain.Joke;

import java.util.List;

public interface JokeRepository {
    List<Joke> getAllJoke();

    List<Joke> getAllByCategory(String category);
}
