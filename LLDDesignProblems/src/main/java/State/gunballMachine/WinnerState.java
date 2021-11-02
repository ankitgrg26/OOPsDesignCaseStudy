package State.gunballMachine;

public class WinnerState implements State {
    GumballMachine gumballMachine;

    public WinnerState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Please wait we are already giving you gumball");
    }

    @Override
    public void ejectCoin() {
        System.out.println("Sorry you already turned the creak");
    }

    @Override
    public void turnCreak() {
        System.out.println("turning twice don't give you two gumball");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() == 0) {
            gumballMachine.setCurrentState(gumballMachine.getSoldOutState());
            return;
        }
        gumballMachine.releaseBall();
        System.out.println("you are a winner you got two gumball");
        if (gumballMachine.getCount() > 0) {
            gumballMachine.setCurrentState(gumballMachine.getNoCoinState());
        } else {
            gumballMachine.setCurrentState(gumballMachine.getSoldOutState());
        }
    }
}
