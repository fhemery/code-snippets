package test.rules;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Counter {
    private static int counter = 0;

    public Counter increment() {
        ++counter;
        return this;
    }

    public int get() {
        return counter;
    }

}

public class IndependentTest {
    public Counter counter = new Counter();

    @Test
    public void should_return0ByDefault() {
        assertEquals(0, counter.get());
    }

    @Test
    public void should_returnOneAfterOneIncrement() {
        counter.increment();
        assertEquals(1, counter.get());
    }
}

class BetterCounter {
    private int counter = 0;

    public BetterCounter increment() {
        ++counter;
        return this;
    }

    public int get() {
        return counter;
    }

}

class BetterIndependentTest {
    BetterCounter counter;

    @BeforeEach
    public void setup() {
        counter = new BetterCounter();
    }

    @Test
    public void should_return0ByDefault() {
        assertEquals(0, counter.get());
    }

    @Test
    public void should_returnOneAfterOneIncrement() {
        counter.increment();
        assertEquals(1, counter.get());
    }
}