package pl.akademiaspecjalistowit.jokeapp.service;

import pl.akademiaspecjalistowit.jokeapp.model.Joke;
import pl.akademiaspecjalistowit.jokeapp.provider.JokeDataProvider;
import pl.akademiaspecjalistowit.jokeapp.provider.JokeProvider;
import pl.akademiaspecjalistowit.jokeapp.repository.InMemmoryJokeRepository;

public class JokeServiceImpl implements JokeService {
    private final JokeProvider jokeProvider;

    @Override
    public Joke getJoke() {
        return jokeProvider.getJoke();
    }

    public JokeServiceImpl() {
       jokeProvider = new JokeDataProvider(new InMemmoryJokeRepository());
    }
}

