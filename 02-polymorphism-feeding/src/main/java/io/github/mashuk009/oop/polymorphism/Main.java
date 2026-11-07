package io.github.mashuk009.oop.polymorphism;

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
            if (!type.equals("dog") && !type.equals("cat")) {
                System.out.println("Incorrect input. Unsupported pet type");
                continue;
            }
            String name = scanner.next();
            int age = readInt(scanner);
            if (age <= 0) {
                System.out.println("Incorrect input. Age <= 0");
                continue;
            }

            double mass = readDouble(scanner);
            if (mass <= 0) {
                System.out.println("Incorrect input. Mass <= 0");
                continue;
            }

            Animal pet;

            if (type.equals("dog")) {
                pet = new Dog(name, age, mass);
            } else {
                pet = new Cat(name, age, mass);
            }

            pets.add(pet);
        }

        for (Animal pet : pets) {
            System.out.println(pet);
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

    public static double readDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.println("Could not parse a number. Please, try again");
            scanner.next();
        }
        return scanner.nextDouble();
    }

}

