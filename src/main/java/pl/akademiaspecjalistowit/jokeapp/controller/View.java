package pl.akademiaspecjalistowit.jokeapp.controller;

import pl.akademiaspecjalistowit.jokeapp.service.JokeService;
import pl.akademiaspecjalistowit.jokeapp.service.JokeServiceImpl;

import java.util.Scanner;

public class View {
    JokeService jokeService;

    public View() {
        this.jokeService = new JokeServiceImpl();
    }

    public void run() {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        try {
            while (!exit) {
                exit = printMenu(scanner);
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
            run();
        }
    }

    private boolean printMenu(Scanner scanner) {
        System.out.println();
        System.out.println("1) Show joke");
        System.out.println("2) For exit");
        System.out.print("Enter your choose: ");
        String command = scanner.nextLine();

        switch (command) {
            case "1":
                System.out.println();
                System.out.println(jokeService.getJoke());
                break;
            case "2":
                System.out.println("Close program...");
                return true;
            default:
                System.out.println("Try again");
                break;
        }
        return false;
    }
}
