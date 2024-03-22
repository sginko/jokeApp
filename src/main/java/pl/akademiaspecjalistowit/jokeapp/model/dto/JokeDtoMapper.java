package pl.akademiaspecjalistowit.jokeapp.model.dto;

import pl.akademiaspecjalistowit.jokeapp.model.domain.Joke;

public interface JokeDtoMapper {
    Joke toJoke(JokeDto joke);
}
