package Logger;

public class LoggerDecorator implements LoggerChain {
    private LoggerChain loggerChain;

    @Override
    public void setNextChain(LoggerChain loggerChain) {
        this.loggerChain = loggerChain;
    }

    @Override
    public void process(LoggerData data) {
        data.getResult()
                .append(data.getType())
                .append(" ").append(data.getClassName())
                .append(" ").append(data.getTime())
                .append(" ").append(data.getMsg());
        loggerChain.process(data);
    }
}
