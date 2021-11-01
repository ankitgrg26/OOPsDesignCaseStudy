package Logger;

import Logger.config.LoggerType;

public class LoggerFilter implements LoggerChain {
    private LoggerChain loggerChain;
    LoggerType loggerLevel;

    public LoggerFilter(LoggerType loggerLevel) {
        this.loggerLevel = loggerLevel;
    }
    @Override
    public void setNextChain(LoggerChain loggerChain) {
        this.loggerChain = loggerChain;
    }

    @Override
    public void process(LoggerData data) {
        if(data.getType().getLevel() < loggerLevel.getLevel()) {
            return;
        }
        loggerChain.process(data);

    }
}
