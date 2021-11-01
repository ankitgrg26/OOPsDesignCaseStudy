package Logger;

public interface LoggerChain {
    void setNextChain(LoggerChain loggerChain);
    void process(LoggerData string);
}
