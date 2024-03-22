package pl.akademiaspecjalistowit.jokeapp.service.dto;

import pl.akademiaspecjalistowit.jokeapp.model.Joke;

public interface JokeDtoMapper {
    Joke toJoke(JokeDto joke);
}
