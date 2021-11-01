package coffee.machine;

import coffee.machine.factory.BeverageFactory;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.concurrent.ExecutorService;



public class CoffeeMachine {
    private final ExecutorService executorService;
    private final BeverageFactory beverageFactory;

    @Inject
    public CoffeeMachine(@Named("CoffeeMachineOutlet") final ExecutorService executorService,
                         final BeverageFactory beverageFactory) {
        this.executorService = executorService;
        this.beverageFactory = beverageFactory;
    }

    public void prepareBeverage(final String type) {
        System.out.println("Order received for "+type);
        try {
            executorService.submit(beverageFactory.getBeverageRunnable(type));
        } catch (Exception e) {
            System.out.println("error "+e.getMessage());
        }
    }
}
