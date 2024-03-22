package pl.akademiaspecjalistowit.jokeapp.service.provider;

import pl.akademiaspecjalistowit.jokeapp.model.Joke;

public interface JokeProvider {
    Joke getJoke();

    Joke getJokeByCategory(String category);
}
