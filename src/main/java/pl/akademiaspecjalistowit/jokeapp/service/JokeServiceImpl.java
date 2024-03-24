package pl.akademiaspecjalistowit.jokeapp.service;

import pl.akademiaspecjalistowit.jokeapp.model.Joke;
import pl.akademiaspecjalistowit.jokeapp.provider.JokeDataProvider;
import pl.akademiaspecjalistowit.jokeapp.provider.JokeProvider;
import pl.akademiaspecjalistowit.jokeapp.repository.InMemoryJokeRepository;
import pl.akademiaspecjalistowit.jokeapp.repository.FileJokeRepository;
import java.util.Random;

public class JokeServiceImpl implements JokeService {
    private final JokeProvider jokeProvider;

    @Override
    public Joke getJoke() {
        return jokeProvider.getJoke();
    }

    public JokeServiceImpl() {
        Random random = new Random();
        int choice = random.nextInt(2);

        if (choice == 0) {
            this.jokeProvider = new JokeDataProvider(new InMemoryJokeRepository());
        } else {
            this.jokeProvider = new JokeDataProvider(new FileJokeRepository());
        }
    }
}

