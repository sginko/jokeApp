package pl.akademiaspecjalistowit.jokeapp;

import pl.akademiaspecjalistowit.jokeapp.controller.UserController;

public class JokeAppApplication {

    public static void main(String[] args){
        UserController userController = new UserController();

        userController.run();
    }
}
