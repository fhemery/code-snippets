package test.approval.overload;

import java.util.List;
import java.util.Random;

public class InterfacedFourTwoOne {
    private DiceGenerator generator;

    InterfacedFourTwoOne(DiceGenerator generator){
        this.generator = generator;
    }

    public boolean roll() {
        var dices = generator.generateDices();

        return dices.contains(4) && dices.contains(2) && dices.contains(1);
    }
}

class RandomDiceGenerator implements DiceGenerator {
    @Override
    public List<Integer> generateDices() {
        var rand = new Random();
        return rand.ints(3, 1, 6).boxed().toList();
    }
}
