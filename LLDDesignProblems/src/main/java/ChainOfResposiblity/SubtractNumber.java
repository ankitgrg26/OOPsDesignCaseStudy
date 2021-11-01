package ChainOfResposiblity;

public class SubtractNumber implements Chain {
    private Chain nextChain;

    @Override
    public void setNextChain(Chain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void calculate(Numbers request) {
        if (request.getCommand().equals("SUB")) {
            System.out.println(request.getA() + " SUB " + request.getB() + " = " + (request.getA() - request.getB()));
            return;
        }
        nextChain.calculate(request);
    }
}
