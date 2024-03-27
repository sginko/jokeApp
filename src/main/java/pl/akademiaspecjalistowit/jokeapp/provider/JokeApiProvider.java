package pl.akademiaspecjalistowit.jokeapp.provider;

import pl.akademiaspecjalistowit.jokeapp.httpclient.JokeCategoryDto;
import pl.akademiaspecjalistowit.jokeapp.httpclient.JokeClientService;
import pl.akademiaspecjalistowit.jokeapp.httpclient.JokeDtoMapper;
import pl.akademiaspecjalistowit.jokeapp.model.Joke;
import pl.akademiaspecjalistowit.jokeapp.model.JokeDto;
import pl.akademiaspecjalistowit.jokeapp.service.JokeService;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class JokeApiProvider implements JokeProvider {
    private final JokeClientService jokeClientService;

    public JokeApiProvider() {
        this.jokeClientService = new JokeClientService();
    }

    @Override
    public Joke getJoke() {
        JokeDto jokeDto = jokeClientService.fetchJokeDto();
        Joke joke = JokeDtoMapper.mapToJoke(jokeDto);
        return joke;
    }

    @Override
    public Joke getJokeByCategory(String category) {
        JokeDto jokeDto = jokeClientService.fetchJokeDtoByCategory(category);
        Joke joke = JokeDtoMapper.mapToJoke(jokeDto);
        return joke;
    }

    @Override
    public Set<String> getAllNamesOfCategories() {
        JokeCategoryDto category = jokeClientService.getCategory();
        return category.getCategories();
    }

//    private Joke mapToJoke(JokeDto jokeDto) {
//        return new Joke(UUID.randomUUID(), jokeDto.getSetup(), jokeDto.getCategory());
//    }


    //java

//    @Override
//    public Joke getJoke() {
//        HttpRequest request = HttpRequest.newBuilder()
//                .GET()
//                .uri(URI.create("https://v2.jokeapi.dev/joke/Any"))
//                .build();
//        return getResponse(request);
//    }
//
//    @Override
//    public Joke getJokeByCategory(String category) {
//        HttpRequest request = HttpRequest.newBuilder()
//                .GET()
//                .uri(URI.create("https://v2.jokeapi.dev/joke/" + category))
//                .build();
//        return getResponse(request);
//    }
//
//    private Joke getResponse(HttpRequest request) {
//        try {
//            HttpResponse<String> response = httpClient.send(
//                    request, HttpResponse.BodyHandlers.ofString());
//
//            ObjectMapper objectMapper = new ObjectMapper();
//            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//            return JokeDtoMapper.toJoke(objectMapper.readValue(response.body(), JokeDto.class));
//        } catch (IOException | InterruptedException ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }

}
