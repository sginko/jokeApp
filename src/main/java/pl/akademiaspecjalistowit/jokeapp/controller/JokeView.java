package pl.akademiaspecjalistowit.jokeapp.controller;

import pl.akademiaspecjalistowit.jokeapp.provider.JokeProvider;
import pl.akademiaspecjalistowit.jokeapp.repository.JokeRepository;
import pl.akademiaspecjalistowit.jokeapp.service.JokeService;
import pl.akademiaspecjalistowit.jokeapp.service.JokeServiceImpl;

import java.util.Scanner;

public class JokeView {
    JokeService jokeService;

    public JokeView() {
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
        System.out.println("2) Show joke from selected category");
        System.out.println("3) For exit");
        System.out.print("Enter your choose: ");
        String command = scanner.nextLine();

        switch (command) {
            case "1":
                System.out.println();
                System.out.println(jokeService.getJoke());
                break;
            case "2":
                System.out.println("Available categories: " + jokeService.getAllNamesOfCategories());
                System.out.print("Enter category: ");
                String category = scanner.nextLine().toLowerCase();
                System.out.println(jokeService.getJoke(category));
                break;
            case "3":
                System.out.println("Close program...");
                System.exit(0);
                return true;
            default:
                System.out.println("Try again");
                break;
        }
        return false;
    }
}
