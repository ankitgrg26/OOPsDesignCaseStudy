package ChainOfResposiblity;

public class AddNumbers implements Chain {
    private Chain nextChain;

    @Override
    public void setNextChain(Chain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void calculate(Numbers request) {
        if (request.getCommand().equals("ADD")) {
            System.out.println(request.getA() + " ADD " + request.getB() + " = " + (request.getB() + request.getA()));
            return;
        }
        nextChain.calculate(request);
    }
}
