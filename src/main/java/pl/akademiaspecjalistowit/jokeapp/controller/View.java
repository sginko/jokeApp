package pl.akademiaspecjalistowit.jokeapp.controller;

import pl.akademiaspecjalistowit.jokeapp.model.Joke;
import pl.akademiaspecjalistowit.jokeapp.service.JokeService;
import pl.akademiaspecjalistowit.jokeapp.service.JokeServiceImpl;

public class View {
    JokeService jokeService;

    public View() {
        this.jokeService = new JokeServiceImpl();
    }

    public void run() {
        System.out.println(jokeService.getJoke());
    }
}
