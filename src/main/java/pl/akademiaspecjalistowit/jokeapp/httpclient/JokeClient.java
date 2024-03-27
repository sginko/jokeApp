package pl.akademiaspecjalistowit.jokeapp.httpclient;

import pl.akademiaspecjalistowit.jokeapp.model.JokeDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JokeClient {
    @GET("/joke/Any")
    Call<JokeDto> getJoke();

    @GET("/joke/{category}")
    Call<JokeDto> getJokeByCategory(@Path("category") String category);

    @GET("/categories")
    Call<JokeCategoryDto> getCategories();
}
