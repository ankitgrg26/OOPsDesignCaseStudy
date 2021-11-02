package State.gunballMachine;

import java.util.Random;

public class HasCoinState implements State {
    GumballMachine gumballMachine;
    Random randomWinner = new Random(System.currentTimeMillis());

    public HasCoinState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Machine already has coin");
    }

    @Override
    public void ejectCoin() {
        gumballMachine.setCurrentState(gumballMachine.getNoCoinState());
        System.out.println("Coin out");
    }

    @Override
    public void turnCreak() {
        System.out.println("your turn");
        int winner = randomWinner.nextInt(10);
        if (winner == 0 && gumballMachine.getCount() > 1) {
            gumballMachine.setCurrentState(gumballMachine.getWinnerState());
        } else {
            gumballMachine.setCurrentState(gumballMachine.getSoldState());
        }
    }

    @Override
    public void dispense() {
        System.out.println("no gumball to dispense");
    }
}
