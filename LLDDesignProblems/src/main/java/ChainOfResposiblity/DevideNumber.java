package ChainOfResposiblity;

public class DevideNumber implements Chain {
    private Chain nextChain;

    @Override
    public void setNextChain(Chain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void calculate(Numbers request) {
        if (request.getCommand().equals("DIV")) {
            System.out.println(request.getA() + " DIV " + request.getB() + " = " + (request.getA() / request.getB()));
            return;
        }
        System.out.println("No Command found");
    }
}
