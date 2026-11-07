package io.github.mashuk009.oop.iterator;

import java.util.List;

public class AnimalIterator implements BaseIterator<Animal> {

    private final List<Animal> animals;
    private int currentIndex;

    public AnimalIterator(List<Animal> animals) {
        this.animals = animals;
        this.currentIndex = 0;
    }

    @Override
    public Animal next() {
        Animal animal = animals.get(currentIndex);
        currentIndex++;
        return animal;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < animals.size();
    }

    @Override
    public void reset() {
        currentIndex = 0;
    }
}
