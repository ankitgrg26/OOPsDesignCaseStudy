package Logger;

import Logger.config.LoggerType;
import lombok.Getter;

import java.time.Instant;

@Getter
public class LoggerData {
    private String msg;
    private LoggerType type;
    private String className;
    private Instant time;
    private StringBuilder result;

    public LoggerData(String msg, LoggerType type, String className, Instant time) {
        this.msg = msg;
        this.type = type;
        this.className = className;
        this.time = time;
        result = new StringBuilder();
    }
}
