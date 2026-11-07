package io.github.mashuk009.oop.immutability;

public class Dog extends Animal {

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public Animal withAge(int age) {
        return new Dog(getName(), age);
    }

    @Override
    public String toString() {
        return "Dog name = " + getName() + ", age = " + getAge();
    }
}
