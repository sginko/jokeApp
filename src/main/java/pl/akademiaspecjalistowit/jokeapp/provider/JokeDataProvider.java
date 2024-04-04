package pl.akademiaspecjalistowit.jokeapp.provider;

import pl.akademiaspecjalistowit.jokeapp.model.Joke;
import pl.akademiaspecjalistowit.jokeapp.repository.JokeRepository;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class JokeDataProvider implements JokeProvider {
    private final JokeRepository jokeRepository;

    public JokeDataProvider(JokeRepository jokeRepository) {
        this.jokeRepository = jokeRepository;
    }

    @Override
    public Joke getJoke() {
        List<Joke> jokes = jokeRepository.getAllJokes();
        Random random = new Random();
        int randomIndex = random.nextInt(jokes.size());
        return jokes.get(randomIndex);
    }

    @Override
    public Joke getJokeByCategory(String category) {
        List<Joke> jokes = jokeRepository.getAllByCategory(category);
        Random random = new Random();
        int randomIndex = random.nextInt(jokes.size());
        return jokes.get(randomIndex);
    }

    @Override
    public Set<String> getAllNamesOfCategories() {
        return jokeRepository.getAllNamesOfCategories();
    }
}
