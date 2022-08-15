package test.rules;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SlowClass {
    public int aMethod() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return 42;
    }
}

class Sleeper {
    public void sleep(int durationInMillis) {
        try {
            Thread.sleep(durationInMillis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class BetterSlowClass {

    private Sleeper sleeper;

    BetterSlowClass(Sleeper sleeper) {
        this.sleeper = sleeper;
    }

    public int aMethod() {
        sleeper.sleep(5000);
        return 42;
    }
}

class SleeperMock extends Sleeper {
    @Override
    public void sleep(int durationInMillis) {
    }
}

public class FastTest {

    @Test
    public void should_notBeTestedLikeThis() {
        var slow = new SlowClass();
        assertEquals(42, slow.aMethod());
    }

    @Test
    public void should_notBeTestedLikeThisAsItDoesNotWork() {
        try (MockedStatic<Thread> thread = Mockito.mockStatic(Thread.class)) {
            thread.when(() -> Thread.sleep(5000));

            var slow = new SlowClass();
            assertEquals(42, slow.aMethod());
        }
    }

    @Test
    public void should_ratherBeImplementedLikeThis() {
        var betterSlow = new BetterSlowClass(new SleeperMock());

        var result = betterSlow.aMethod();

        assertEquals(42, result);
    }
}
