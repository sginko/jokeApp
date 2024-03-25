package pl.akademiaspecjalistowit.jokeapp.repository;

import pl.akademiaspecjalistowit.jokeapp.model.Joke;

import java.util.List;
import java.util.Set;

public interface JokeRepository {
    List<Joke> getAllJokes();

    List<Joke> getAllByCategory(String category);

    Set<String> getAllNamesOfCategories();
}
