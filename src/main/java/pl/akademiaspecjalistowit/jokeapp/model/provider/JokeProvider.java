package pl.akademiaspecjalistowit.jokeapp.model.provider;

import pl.akademiaspecjalistowit.jokeapp.model.domain.Joke;

public interface JokeProvider {
    Joke getJoke();

    Joke getJokeByCategory(String category);
}
