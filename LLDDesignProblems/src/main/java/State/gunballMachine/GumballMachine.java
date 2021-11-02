package State.gunballMachine;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GumballMachine {
    private State hasCoinState;
    private State noCoinState;
    private State soldState;
    private State soldOutState;
    private State currentState;
    private State winnerState;
    int count;

    public GumballMachine(int count) {
        this.count = count;
        hasCoinState = new HasCoinState(this);
        noCoinState = new NoCoinState(this);
        soldOutState = new SoldOutState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);
        if (count > 0) {
            currentState = noCoinState;
        } else {
            currentState = soldOutState;
        }
    }

    public void insertCoin() {
        currentState.insertCoin();
    }

    public void ejectCoin() {
        currentState.ejectCoin();
    }

    public void turnCreak() {
        currentState.turnCreak();
        currentState.dispense();
    }

    public void releaseBall() {
        System.out.println("A gumball come rolling out the slot ...");
        count = count - 1;
    }
}
