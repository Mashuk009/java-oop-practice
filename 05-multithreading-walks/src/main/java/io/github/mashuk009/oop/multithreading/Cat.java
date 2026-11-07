package io.github.mashuk009.oop.multithreading;

import java.util.concurrent.TimeUnit;

public class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public double goToWalk() {
        double time = getAge() * 0.25;

        try {
            TimeUnit.MILLISECONDS.sleep((long) (time * 1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return time;
    }

    @Override
    public String toString() {
        return "Cat name = " + getName() + ", age = " + getAge();
    }
}
