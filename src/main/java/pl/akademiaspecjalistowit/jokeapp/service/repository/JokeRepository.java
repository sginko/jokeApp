package pl.akademiaspecjalistowit.jokeapp.service.repository;

import pl.akademiaspecjalistowit.jokeapp.model.Joke;

import java.util.List;

public interface JokeRepository {
    List<Joke> getAllJoke();

    List<Joke> getAllByCategory(String category);
}
