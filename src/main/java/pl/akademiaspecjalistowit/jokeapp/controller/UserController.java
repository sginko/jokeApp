package pl.akademiaspecjalistowit.jokeapp.controller;

import pl.akademiaspecjalistowit.jokeapp.model.domain.Joke;

public class UserController {
    Joke joke = new Joke();
    public void run() {
        System.out.println(joke.getContent());
    }
}
