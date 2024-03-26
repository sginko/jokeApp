package pl.akademiaspecjalistowit.jokeapp;

import pl.akademiaspecjalistowit.jokeapp.controller.JokeView;

public class JokeAppApplication {

    public static void main(String[] args) {
        JokeView userController = new JokeView();

        userController.run();
    }
}
