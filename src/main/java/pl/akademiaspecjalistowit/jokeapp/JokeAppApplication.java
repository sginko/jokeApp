package pl.akademiaspecjalistowit.jokeapp;

import pl.akademiaspecjalistowit.jokeapp.controller.View;

public class JokeAppApplication {

    public static void main(String[] args) {
        View userController = new View();

        userController.run();
    }
}
