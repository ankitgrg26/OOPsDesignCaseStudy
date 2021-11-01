package ChainOfResposiblity;

public class TestChain {
    public static void main(String[] args) {
        Chain chain1 = new AddNumbers();
        Chain chain2 = new SubtractNumber();
        Chain chain3 = new MultiplyNumber();
        Chain chain4 = new DevideNumber();
        chain1.setNextChain(chain2);
        chain2.setNextChain(chain3);
        chain3.setNextChain(chain4);
        Numbers number = new Numbers(12, 3, "DIV");
        chain1.calculate(number);
    }
}
