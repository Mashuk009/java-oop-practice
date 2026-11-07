package io.github.mashuk009.oop.immutability;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> pets = new ArrayList<>();

        int count = readInt(scanner);
        readPets(scanner, pets, count);

        List<Animal> updatedPets = increaseAge(pets);
        updatedPets.forEach(System.out::println);

        scanner.close();
    }

    public static void readPets(
            Scanner scanner,
            List<Animal> pets,
            int count
    ) {
        if (count == 0) {
            return;
        }

        String type = scanner.next();

        if (!type.equals("dog") && !type.equals("cat")) {
            System.out.println("Incorrect input. Unsupported pet type");
            readPets(scanner, pets, count - 1);
            return;
        }

        String name = scanner.next();
        int age = readInt(scanner);

        if (age <= 0) {
            System.out.println("Incorrect input. Age <= 0");
            readPets(scanner, pets, count - 1);
            return;
        }

        Animal pet;

        if (type.equals("dog")) {
            pet = new Dog(name, age);
        } else {
            pet = new Cat(name, age);
        }

        pets.add(pet);

        readPets(scanner, pets, count - 1);
    }

    public static int readInt(Scanner scanner) {
        if (!scanner.hasNextInt()) {
            System.out.println(
                    "Could not parse a number. Please, try again"
            );
            scanner.next();
            return readInt(scanner);
        }

        return scanner.nextInt();
    }

    public static List<Animal> increaseAge(List<Animal> pets) {
        return pets.stream()
                .map(pet -> pet.getAge() > 10
                        ? pet.withAge(pet.getAge() + 1)
                        : pet)
                .toList();
    }

}
