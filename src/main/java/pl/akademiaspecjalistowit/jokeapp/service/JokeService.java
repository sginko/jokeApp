package pl.akademiaspecjalistowit.jokeapp.service;

public interface JokeService {
    JokeView getJoke();

    JokeView getJokeB(String category);
}
