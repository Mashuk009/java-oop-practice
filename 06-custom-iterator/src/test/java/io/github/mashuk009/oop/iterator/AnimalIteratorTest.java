package io.github.mashuk009.oop.iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class AnimalIteratorTest {

    private final Animal dog = new Dog("Rex", 5);
    private final Animal cat = new Cat("Tom", 3);

    @Test
    void emptyListHasNoNext() {
        AnimalIterator iterator = new AnimalIterator(List.of());

        assertFalse(iterator.hasNext());
    }

    @Test
    void nextReturnsAnimalsInOrder() {
        AnimalIterator iterator = new AnimalIterator(List.of(dog, cat));

        assertSame(dog, iterator.next());
        assertSame(cat, iterator.next());
    }

    @Test
    void hasNextBecomesFalseAfterLastElement() {
        AnimalIterator iterator = new AnimalIterator(List.of(dog, cat));

        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertFalse(iterator.hasNext());
    }

    @Test
    void resetReturnsIteratorToStart() {
        AnimalIterator iterator = new AnimalIterator(List.of(dog, cat));
        iterator.next();
        iterator.next();

        iterator.reset();

        assertTrue(iterator.hasNext());
        assertSame(dog, iterator.next());
    }

    @Test
    void toStringOfPetsIsReadable() {
        assertEquals("Dog name = Rex, age = 5", dog.toString());
        assertEquals("Cat name = Tom, age = 3", cat.toString());
    }
}
