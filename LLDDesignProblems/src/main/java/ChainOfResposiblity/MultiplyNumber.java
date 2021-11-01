package ChainOfResposiblity;

public class MultiplyNumber implements Chain {
    private Chain nextChain;

    @Override
    public void setNextChain(Chain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void calculate(Numbers request) {
        if (request.getCommand().equals("MUL")) {
            System.out.println(request.getA() + " MUL " + request.getB() + " = " + (request.getB() * request.getA()));
            return;
        }
        nextChain.calculate(request);
    }
}
