package io.github.mashuk009.oop.polymorphism;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AnimalFeedTest {

    private static final double DELTA = 0.0001;

    @Test
    void catFeedIsTenPercentOfMass() {
        Animal cat = new Cat("Tom", 3, 4.0);

        assertEquals(0.4, cat.getFeedInfoKg(), DELTA);
    }

    @Test
    void dogFeedIsThirtyPercentOfMass() {
        Animal dog = new Dog("Rex", 5, 10.0);

        assertEquals(3.0, dog.getFeedInfoKg(), DELTA);
    }

    @Test
    void catToStringContainsFormattedValues() {
        Animal cat = new Cat("Tom", 3, 4.0);

        assertEquals("Cat name = Tom, age = 3, mass = 4.00, feed = 0.40", cat.toString());
    }
}
