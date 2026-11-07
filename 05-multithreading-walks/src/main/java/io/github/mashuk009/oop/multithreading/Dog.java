package io.github.mashuk009.oop.multithreading;

import java.util.concurrent.TimeUnit;

public class Dog extends Animal {

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public double goToWalk() {
        double time = getAge() * 0.5;

        try {
            TimeUnit.MILLISECONDS.sleep((long) (time * 1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return time;
    }

    @Override
    public String toString() {
        return "Dog name = " + getName() + ", age = " + getAge();
    }
}
