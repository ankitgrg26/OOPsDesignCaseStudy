package State.gunballMachine;

public class NoCoinState implements State {
    GumballMachine gumballMachine;

    public NoCoinState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("you inserted a coin");
        gumballMachine.setCurrentState(gumballMachine.getHasCoinState());
    }

    @Override
    public void ejectCoin() {
        System.out.println("No Coin");
    }

    @Override
    public void turnCreak() {
        System.out.println("Please insert a coin");
    }

    @Override
    public void dispense() {
        System.out.println("Please insert a coin");
    }
}
