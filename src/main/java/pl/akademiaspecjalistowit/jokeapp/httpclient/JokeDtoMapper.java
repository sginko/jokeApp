package pl.akademiaspecjalistowit.jokeapp.httpclient;

import pl.akademiaspecjalistowit.jokeapp.model.Joke;
import pl.akademiaspecjalistowit.jokeapp.model.JokeDto;

import java.util.UUID;

public interface JokeDtoMapper {
    static Joke mapToJoke(JokeDto jokeDto) {
        return new Joke(UUID.randomUUID(), jokeDto.getSetup() + "\n" + jokeDto.getDelivery(), jokeDto.getCategory());
    }

    // java
//    static Joke toJoke(JokeDto jokeDto) {
//        return new Joke(jokeDto.getSetup() + "\n" + jokeDto.getDelivery(), jokeDto.getCategory());
//    }

}
