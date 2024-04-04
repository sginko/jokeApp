package pl.akademiaspecjalistowit.jokeapp.service;

import pl.akademiaspecjalistowit.jokeapp.model.Joke;

import java.util.Set;

public interface JokeService {
    Joke getJoke();

    Joke getJoke(String category);

    Set<String> getAllNamesOfCategories();
}
