package pl.akademiaspecjalistowit.jokeapp.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import pl.akademiaspecjalistowit.jokeapp.model.Joke;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FileJokeRepositoryTest {
    private FileJokeRepository fileJokeRepository;

    @BeforeEach
    void setUp() {
        fileJokeRepository = new FileJokeRepository("src/main/resources/jokes.json");
    }

    @Test
    void should_get_all_jokes_from_file_repository() {
        //Given

        //When
        List<Joke> allJokes = fileJokeRepository.getAllJokes();

        //Then
        assertThat(allJokes).isNotNull();
        assertThat(allJokes).size().isEqualTo(5);
    }

    @Test
    void should_get_all_jokes_by_category_from_file_repository() {
        //Given

        //When
        List<Joke> allJokes = fileJokeRepository.getAllByCategory("Category 1");

        //Then
        assertThat(allJokes).isNotNull();
        assertThat(allJokes).size().isEqualTo(3);
    }

    @Test
    void should_get_all_names_of_category_from_file_repository() {
        //Given

        //When
        Set<String> allNamesOfCategories = fileJokeRepository.getAllNamesOfCategories();

        //Then
        assertThat(allNamesOfCategories).isNotNull();
        assertThat(allNamesOfCategories).size().isEqualTo(2);
    }

    @Test
    void should_get_RuntimeException() {
        //Given

        //When
        Executable e = () -> new FileJokeRepository("src/main/resources/jokesOld.txt");

        //Then
        assertThrows(RuntimeException.class, e);
    }

}