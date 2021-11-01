package ChainOfResposiblity;

import lombok.Getter;

@Getter
public class Numbers {
    private int a;
    private int b;
    private String command;
    public Numbers(int a, int b, String command) {
        this.a = a;
        this.b = b;
        this.command = command;
    }
}

