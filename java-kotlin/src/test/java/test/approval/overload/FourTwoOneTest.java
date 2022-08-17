package test.approval.overload;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class FourTwoOneTestOverload extends TestableFourTwoOne {

    private ArrayList<Integer> dices = new ArrayList<>();
    @NotNull
    @Override
    public List<Integer> getDices() {
        return dices;
    }

    public void setDices(int d1, int d2, int d3) {
        dices.add(d1);
        dices.add(d2);
        dices.add(d3);
    }
}

class FourTwoOneTest {

    @Test
    public void should_returnFalseOnBadRoll() {
        var fourTwoOne = new FourTwoOneTestOverload();
        fourTwoOne.setDices(1, 2, 3);
        Assertions.assertFalse(fourTwoOne.roll());
    }

    @Test
    public void should_returnTrueOnBadRoll() {
        var fourTwoOne = new FourTwoOneTestOverload();
        fourTwoOne.setDices(1, 2, 4);
        Assertions.assertTrue(fourTwoOne.roll());
    }
}