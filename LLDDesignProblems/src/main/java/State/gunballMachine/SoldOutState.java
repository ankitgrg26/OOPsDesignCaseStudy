package State.gunballMachine;

public class SoldOutState implements State {
    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    @Override
    public void insertCoin() {
        System.out.println("We are sold out");
    }

    @Override
    public void ejectCoin() {
        System.out.println("No Coin to eject");
    }

    @Override
    public void turnCreak() {
        System.out.println("We are sold out");
    }

    @Override
    public void dispense() {
        System.out.println("We are sold out");
    }
}
