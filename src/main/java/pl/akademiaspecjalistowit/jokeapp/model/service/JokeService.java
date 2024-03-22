package pl.akademiaspecjalistowit.jokeapp.model.service;

public interface JokeService {
    JokeView getJoke();

    JokeView getJokeB(String category);
}
