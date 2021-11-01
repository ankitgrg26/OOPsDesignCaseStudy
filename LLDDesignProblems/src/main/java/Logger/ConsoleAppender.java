package Logger;

public class ConsoleAppender implements LoggerChain {
    private LoggerChain loggerChain;

    @Override
    public void setNextChain(LoggerChain loggerChain) {
        this.loggerChain = loggerChain;
    }

    @Override
    public void process(LoggerData data) {
        System.out.println(data.getResult().toString());
    }
}
