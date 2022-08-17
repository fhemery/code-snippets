package test.approval.overload;

import java.util.Random;

public class UntestableFourTwoOne {
    public boolean roll() {
        var rand = new Random();
        var dices = rand.ints(3, 1, 6).boxed().toList();

        return dices.contains(4) && dices.contains(2) && dices.contains(1);
    }
}
