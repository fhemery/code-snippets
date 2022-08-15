package test.rules;

import org.junit.jupiter.api.Test;

class Circle {
    public static double getArea(int radius) {
        return 3.14 * radius * radius;
    }
}

class CircleTest {
    @Test
    public void should_beCorrect() {
        Circle.getArea(10);
    }
}
