package test.approval.overload;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FixedGenerator implements DiceGenerator {
    private List<Integer> dices;
    FixedGenerator(int d1, int d2, int d3) {
        dices = new ArrayList<>();
        dices.add(d1);
        dices.add(d2);
        dices.add(d3);
    }

    @Override
    public List<Integer> generateDices() {
        return dices;
    }
}

class InterfacedFourTwoOneTest {
    @Test
    public void should_returnFalseOnBadRoll() {
        var fourTwoOne = new InterfacedFourTwoOne(new FixedGenerator(1,2,3));
        Assertions.assertFalse(fourTwoOne.roll());
    }

    @Test
    public void should_returnTrueOnBadRoll() {
        var fourTwoOne = new InterfacedFourTwoOne(new FixedGenerator(1,2,4));
        Assertions.assertTrue(fourTwoOne.roll());
    }
}