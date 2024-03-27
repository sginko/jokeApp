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
    private JokeProvider jokeProvider;
    private final List<JokeProvider> listJokeProviders;
    private int providerIndex;

    public JokeServiceImpl() {
        listJokeProviders = new ArrayList<>();
        listJokeProviders.add(new JokeDataProvider(new FileJokeRepository()));
        listJokeProviders.add(new JokeDataProvider(new InMemoryJokeRepository()));
        listJokeProviders.add(new JokeApiProvider());
        providerIndex = 0;
    }

    @Override
    public Joke getJoke() {
        JokeProvider currentProvider = listJokeProviders.get(providerIndex);
        providerIndex = (providerIndex + 1) % listJokeProviders.size();
        return currentProvider.getJoke();
    }

    @Override
    public Joke getJoke(String category) {
        JokeProvider currentProvider = listJokeProviders.get(providerIndex);
        providerIndex = (providerIndex + 1) % listJokeProviders.size();
        return currentProvider.getJokeByCategory(category);
    }
//    public Joke getJoke(String category) {
//        return jokeProvider.getJokeByCategory(category);
//    }

    @Override
    public Set<String> getAllNamesOfCategories() {
        JokeProvider currentProvider = listJokeProviders.get(providerIndex);
        providerIndex = (providerIndex + 1) % listJokeProviders.size();
        return currentProvider.getAllNamesOfCategories();
    }
//    public Set<String> getAllNamesOfCategories() {
//        return jokeProvider.getAllNamesOfCategories();
//    }
}