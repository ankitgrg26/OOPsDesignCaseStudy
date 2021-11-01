package Logger;

import Logger.config.LoggerType;

import java.time.Instant;

public class LoggerContext implements Logger, LoggerChain {
    private static Logger logger;
    private LoggerChain loggerChain;
    String className;

    public LoggerContext(String className) {
        this.className = className;
    }

    @Override
    public void debug(String s) {
        process(new LoggerData(s, LoggerType.DEBUG, className, Instant.now()));
    }

    @Override
    public void info(String s) {
        process(new LoggerData(s, LoggerType.INFO, className, Instant.now()));
    }

    @Override
    public void error(String s) {
        process(new LoggerData(s, LoggerType.ERROR, className, Instant.now()));
    }

    @Override
    public void setNextChain(LoggerChain loggerChain) {
        this.loggerChain = loggerChain;
    }

    @Override
    public void process(LoggerData data) {
        loggerChain.process(data);
    }
}
