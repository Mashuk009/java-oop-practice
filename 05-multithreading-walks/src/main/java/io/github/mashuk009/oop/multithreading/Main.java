package io.github.mashuk009.oop.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> pets = new ArrayList<>();

        int count = readInt(scanner);

        readPets(scanner, pets, count);

        scanner.close();

        long programStart = System.nanoTime();
        List<Thread> threads = startWalks(pets, programStart);


        boolean interrupted = false;

        for (Thread thread : threads) {
            while (true) {
                try {
                    thread.join();
                    break;
                } catch (InterruptedException e) {
                    interrupted = true;
                }
            }
        }

        if (interrupted) {
            Thread.currentThread().interrupt();
        }

    }

    private static List<Thread> startWalks(List<Animal> pets, long programStart) {
        List<Thread> threads = new ArrayList<>();

        for (Animal pet : pets) {
            Thread thread = new Thread(() -> {
                long startTime = System.nanoTime();

                pet.goToWalk();

                long endTime = System.nanoTime();

                double startSeconds =
                        (startTime - programStart) / 1_000_000_000.0;

                double endSeconds =
                        (endTime - programStart) / 1_000_000_000.0;

                System.out.printf(
                        Locale.US,
                        "%s, start time = %.2f, end time = %.2f%n",
                        pet,
                        startSeconds,
                        endSeconds
                );
            });

            threads.add(thread);
            thread.start();
        }
        return threads;
    }

    public static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println(
                    "Could not parse a number. Please, try again"
            );
            scanner.next();
        }

        return scanner.nextInt();
    }

    private static void readPets(
            Scanner scanner, List<Animal> pets, int count) {
        for (int i = 0; i < count; i++) {
            String type = scanner.next();

            if (!type.equals("dog") && !type.equals("cat")) {
                System.out.println(
                        "Incorrect input. Unsupported pet type"
                );
                continue;
            }

            String name = scanner.next();
            int age = readInt(scanner);

            if (age <= 0) {
                System.out.println("Incorrect input. Age <= 0");
                continue;
            }

            Animal pet;

            if (type.equals("dog")) {
                pet = new Dog(name, age);
            } else {
                pet = new Cat(name, age);
            }

            pets.add(pet);
        }
    }

}
