package pl.akademiaspecjalistowit.jokeapp.repository;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.akademiaspecjalistowit.jokeapp.model.Joke;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class FileJokeRepository implements JokeRepository {
//    private Map<String, List<Joke>> jokes = sortJokeByCategory(getJokeFromFile());
//
//    @Override
//    public List<Joke> getAllJokes() {
//        return this.jokes.entrySet().stream()
//                .flatMap(entry -> entry.getValue().stream())
//                .toList();
//    }
//
//    @Override
//    public List<Joke> getAllByCategory(String category) {
//        return this.jokes.entrySet().stream()
//                .filter(entry -> entry.getKey().equalsIgnoreCase(category))
//                .flatMap(entry -> entry.getValue().stream())
//                .toList();
//    }
//
//    public Set<String> getAllNamesOfCategories() {
//        return jokes.keySet();
//    }
//
//    private List<Joke> getJokeFromFile() {
//        Path filePathVisits = Path.of("jokes.txt");
//        List<Joke> listJokes = new ArrayList<>();
//        try {
//            List<String> lines = Files.readAllLines(filePathVisits);
//
//            for (String line : lines) {
//                String[] strings = line.split(";");
//                UUID id = UUID.fromString(strings[0].trim());
//                String category = strings[1].trim();
//                String content = strings[2].trim();
//
//                Joke joke = new Joke(id, content, category);
//                listJokes.add(joke);
//            }
//        } catch (IOException e) {
//            System.out.println("Error. Cannot read file");
//        }
//        return listJokes;
//    }
//
//    private Map<String, List<Joke>> sortJokeByCategory(List<Joke> jokes) {
//        Map<String, List<Joke>> sortedJokes = new HashMap<>();
//
//        for (Joke joke : jokes) {
//            String category = joke.getCategory();
//            List<Joke> categoryJokes = sortedJokes.getOrDefault(category, new ArrayList<>());
//            categoryJokes.add(joke);
//            sortedJokes.put(category, categoryJokes);
//        }
//        return sortedJokes;
//    }

    private final Map<String, List<Joke>> jokesWithCategories;

    public FileJokeRepository(String pathToJokesFile) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            jokesWithCategories = objectMapper.readValue(Paths.get(pathToJokesFile).toFile(), new TypeReference<List<Joke>>() {
                    })
                    .stream().collect(Collectors.groupingBy(Joke::getCategory));

        } catch (IOException e) {
            throw new RuntimeException("cannot deserialize Jokes from file", e);
        }
    }

    @Override
    public List<Joke> getAllJokes() {
        return jokesWithCategories.entrySet()
                .stream()
                .flatMap(e->e.getValue().stream())
                .collect(Collectors.toList());
    }

//    @Override
//    public List<Joke> getAllByCategory(String category) {
//        return jokesWithCategories.get(category);
//    }

    @Override
    public List<Joke> getAllByCategory(String category) {
        return this.jokesWithCategories.entrySet().stream()
                .filter(entry -> entry.getKey().equalsIgnoreCase(category))
                .flatMap(entry -> entry.getValue().stream())
                .toList();
    }

    @Override
    public Set<String> getAllNamesOfCategories() {
        return jokesWithCategories.keySet();
    }
}