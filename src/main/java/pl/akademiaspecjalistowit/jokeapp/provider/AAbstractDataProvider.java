package pl.akademiaspecjalistowit.jokeapp.provider;

import pl.akademiaspecjalistowit.jokeapp.model.Joke;

public interface AAbstractDataProvider {
    Joke getRandomJoke();
}
