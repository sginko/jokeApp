package pl.akademiaspecjalistowit.jokeapp.model;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

interface JokeDtoMapper {

    @GET("/joke")
    Joke getJoke(
        @Query("setup") String setup,
        @Query("delivery") String delivery,
        @Query("category") String category);

    @GET("/Any")
    Joke getJoke (@Path("Any") String setup);

    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://v2.jokeapi.dev/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build();


    }
