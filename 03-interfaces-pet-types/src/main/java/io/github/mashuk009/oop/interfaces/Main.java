package io.github.mashuk009.oop.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> pets = new ArrayList<>();

        int count = readInt(scanner);

        for (int i = 0; i < count; i++) {
            String type = scanner.next();

            if (!type.equals("dog")
                    && !type.equals("cat")
                    && !type.equals("hamster")
                    && !type.equals("guinea")) {
                System.out.println("Incorrect input. Unsupported pet type");
                continue;
            }

            String name = scanner.next();
            int age = readInt(scanner);

            if (age <= 0) {
                System.out.println("Incorrect input. Age <= 0");
                continue;
            }

            Animal pet = switch (type) {
                case "dog" -> new Dog(name, age);
                case "cat" -> new Cat(name, age);
                case "hamster" -> new Hamster(name, age);
                default -> new GuineaPig(name, age);
            };

            pets.add(pet);
        }

        for (Animal pet : pets) {
            if (pet instanceof Herbivore) {
                System.out.println(pet);
            }
        }

        for (Animal pet : pets) {
            if (pet instanceof Omnivore) {
                System.out.println(pet);
            }
        }

        scanner.close();
    }

    public static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Could not parse a number. Please, try again");
            scanner.next();
        }
        return scanner.nextInt();
    }

}

