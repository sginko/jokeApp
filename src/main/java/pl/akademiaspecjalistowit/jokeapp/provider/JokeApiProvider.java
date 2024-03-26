package pl.akademiaspecjalistowit.jokeapp.provider;

import pl.akademiaspecjalistowit.jokeapp.httpclient.JokeClientService;
import pl.akademiaspecjalistowit.jokeapp.model.Joke;
import pl.akademiaspecjalistowit.jokeapp.model.JokeDto;

import java.util.Set;
import java.util.UUID;

public class JokeApiProvider implements JokeProvider {
    private final JokeClientService jokeClientService;

    public JokeApiProvider() {
        this.jokeClientService = new JokeClientService();
    }

    @Override
    public Joke getJoke() {
        JokeDto jokeDto = jokeClientService.fetchJokeDto();
        Joke joke = mapToJoke(jokeDto);
        return joke;
    }

    @Override
    public Joke getJokeByCategory(String category) {
        JokeDto jokeDto = jokeClientService.fetchJokeDtoByCategory(category);
        Joke joke = mapToJoke(jokeDto);
        return joke;
    }

    @Override
    public Set<String> getAllNamesOfCategories() {
        return null;
    }

    private Joke mapToJoke(JokeDto jokeDto) {
        return new Joke(UUID.randomUUID(), jokeDto.getSetup(), jokeDto.getCategory());
    }
}
