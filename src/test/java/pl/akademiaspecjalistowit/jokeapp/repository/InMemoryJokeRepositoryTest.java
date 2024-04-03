package pl.akademiaspecjalistowit.jokeapp.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akademiaspecjalistowit.jokeapp.model.Joke;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class InMemoryJokeRepositoryTest {
    private InMemoryJokeRepository inMemoryJokeRepository;

    @BeforeEach
    void setUp() {
        inMemoryJokeRepository = new InMemoryJokeRepository();
    }

    @Test
    void should_get_all_jokes_from_memory_repository() {
        //Given

        //When
        List<Joke> allJokes = inMemoryJokeRepository.getAllJokes();

        //Then
        assertThat(allJokes).isNotNull();
        assertThat(allJokes).size().isEqualTo(5);
    }

    @Test
    void should_get_all_jokes_by_category_from_memory_repository() {
        //Given

        //When
        List<Joke> allJokes = inMemoryJokeRepository.getAllByCategory("Category 1");

        //Then
        assertThat(allJokes).isNotNull();
        assertThat(allJokes).size().isEqualTo(3);
    }

    @Test
    void should_get_all_names_of_category_from_memory_repository() {
        //Given

        //When
        Set<String> allNamesOfCategories = inMemoryJokeRepository.getAllNamesOfCategories();

        //Then
        assertThat(allNamesOfCategories).isNotNull();
        assertThat(allNamesOfCategories).size().isEqualTo(2);
    }
}