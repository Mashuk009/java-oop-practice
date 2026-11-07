package io.github.mashuk009.oop.immutability;

public class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public Animal withAge(int age) {
        return new Cat(getName(), age);
    }

    @Override
    public String toString() {
        return "Cat name = " + getName() + ", age = " + getAge();
    }
}
