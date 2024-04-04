package pl.akademiaspecjalistowit.jokeapp.provider;

import pl.akademiaspecjalistowit.jokeapp.model.Joke;

import java.util.Set;

public interface JokeProvider {
    Joke getJoke();

    Joke getJokeByCategory(String category);

    Set<String> getAllNamesOfCategories();
}
