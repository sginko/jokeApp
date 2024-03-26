package pl.akademiaspecjalistowit.jokeapp.service;

import pl.akademiaspecjalistowit.jokeapp.model.Joke;
import pl.akademiaspecjalistowit.jokeapp.provider.JokeApiProvider;
import pl.akademiaspecjalistowit.jokeapp.provider.JokeDataProvider;
import pl.akademiaspecjalistowit.jokeapp.provider.JokeProvider;
import pl.akademiaspecjalistowit.jokeapp.repository.FileJokeRepository;
import pl.akademiaspecjalistowit.jokeapp.repository.InMemoryJokeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class JokeServiceImpl implements JokeService {
    private List<JokeProvider> jokeProviders;
    private int providerIndex;

    public JokeServiceImpl() {
        jokeProviders = new ArrayList<>();
        jokeProviders.add(new JokeDataProvider(new FileJokeRepository()));
        jokeProviders.add(new JokeDataProvider(new InMemoryJokeRepository()));
        jokeProviders.add(new JokeApiProvider());
        providerIndex = 0;
    }

    @Override
    public Joke getJoke() {
        JokeProvider currentProvider = jokeProviders.get(providerIndex);
        providerIndex = (providerIndex + 1) % jokeProviders.size();
        return currentProvider.getJoke();
    }

    @Override
    public Joke getJoke(String category) {
        JokeProvider currentProvider = jokeProviders.get(providerIndex);
        providerIndex = (providerIndex + 1) % jokeProviders.size();
        return currentProvider.getJokeByCategory(category);
    }
//    public Joke getJoke(String category) {
//        return jokeProvider.getJokeByCategory(category);
//    }

    @Override
    public Set<String> getAllNamesOfCategories() {
        JokeProvider currentProvider = jokeProviders.get(providerIndex);
        providerIndex = (providerIndex + 1) % jokeProviders.size();
        return currentProvider.getAllNamesOfCategories();
    }
//    public Set<String> getAllNamesOfCategories() {
//        return jokeProvider.getAllNamesOfCategories();
//    }
}