package pl.akademiaspecjalistowit.jokeapp.service;

import pl.akademiaspecjalistowit.jokeapp.model.Joke;
import pl.akademiaspecjalistowit.jokeapp.provider.JokeDataProvider;
import pl.akademiaspecjalistowit.jokeapp.provider.JokeProvider;
import pl.akademiaspecjalistowit.jokeapp.repository.FileJokeRepository;
import pl.akademiaspecjalistowit.jokeapp.repository.InMemoryJokeRepository;

import java.util.Random;
import java.util.Set;

public class JokeServiceImpl implements JokeService {
    private final JokeProvider jokeProvider;

    public JokeServiceImpl() {
        if (isInMemoryRepositoryEmpty()) {
            jokeProvider = new JokeDataProvider(new FileJokeRepository());
        } else {
            jokeProvider = new JokeDataProvider(new InMemoryJokeRepository());
        }
    }

    private boolean isInMemoryRepositoryEmpty() {
        InMemoryJokeRepository inMemoryRepository = new InMemoryJokeRepository();
        return inMemoryRepository.getAllJokes().isEmpty();
    }

//    public JokeServiceImpl() {
//        Random random = new Random();
//        int choice = random.nextInt(2);
//
//        if (choice == 0) {
//            this.jokeProvider = new JokeDataProvider(new InMemoryJokeRepository());
//        } else {
//            this.jokeProvider = new JokeDataProvider(new FileJokeRepository());
//        }
//    }

    @Override
    public Joke getJoke() {
        return jokeProvider.getJoke();
    }

    @Override
    public Joke getJoke(String category) {
        return jokeProvider.getJokeByCategory(category);
    }

    @Override
    public Set<String> getAllNamesOfCategories() {
        return jokeProvider.getAllNamesOfCategories();
    }

}

