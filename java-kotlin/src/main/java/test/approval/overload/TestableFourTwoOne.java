package test.approval.overload;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Random;

public class TestableFourTwoOne {
    public boolean roll() {
        List<Integer> dices = getDices();

        return dices.contains(4) && dices.contains(2) && dices.contains(1);
    }

    @NotNull
    protected List<Integer> getDices() {
        var rand = new Random();
        return rand.ints(3, 1, 6).boxed().toList();
    }
}
