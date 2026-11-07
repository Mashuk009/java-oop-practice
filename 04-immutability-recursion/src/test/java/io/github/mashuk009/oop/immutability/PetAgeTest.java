package io.github.mashuk009.oop.immutability;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import java.util.List;
import org.junit.jupiter.api.Test;

class PetAgeTest {

    @Test
    void withAgeReturnsNewObjectAndKeepsOriginalUnchanged() {
        Animal dog = new Dog("Rex", 5);

        Animal older = dog.withAge(6);

        assertNotSame(dog, older);
        assertEquals(5, dog.getAge());
        assertEquals(6, older.getAge());
    }

    @Test
    void withAgeKeepsNameAndType() {
        Animal cat = new Cat("Tom", 3);

        Animal older = cat.withAge(4);

        assertInstanceOf(Cat.class, older);
        assertEquals("Tom", older.getName());
    }

    @Test
    void increaseAgeAddsOneOnlyToPetsOlderThanTen() {
        List<Animal> pets = List.of(new Dog("Rex", 12), new Cat("Tom", 3));

        List<Animal> result = Main.increaseAge(pets);

        assertEquals(13, result.get(0).getAge());
        assertEquals(3, result.get(1).getAge());
    }

    @Test
    void increaseAgeDoesNotChangeSourceList() {
        Animal dog = new Dog("Rex", 12);
        List<Animal> pets = List.of(dog);

        Main.increaseAge(pets);

        assertEquals(12, dog.getAge());
    }
}
