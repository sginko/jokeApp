package pl.akademiaspecjalistowit.jokeapp.repository;

import pl.akademiaspecjalistowit.jokeapp.model.Joke;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class FileJokeRepository implements JokeRepository {
    private Map<String, List<Joke>> jokes = getJokeFromFile();

    @Override
    public List<Joke> getAllJokes() {
        return this.jokes.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream())
                .toList();
    }

    private Map<String, List<Joke>> getJokeFromFile() {
        Path filePathVisits = Path.of("jokes.txt");
        Map<String, List<Joke>> mapJokes = new HashMap<>();
        List<Joke> jokes = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(filePathVisits);

            for (String line : lines) {
                String[] strings = line.split(";");
                UUID id = UUID.fromString(strings[0].trim());
                String category = strings[1].trim();
                String content = strings[2].trim();

                Joke joke = new Joke(id, content);
                jokes.add(joke);
                mapJokes.put(category, jokes);
            }
        } catch (IOException e) {
            System.out.println("Error. Cannot read file");
        }
        return mapJokes;
    }
}
