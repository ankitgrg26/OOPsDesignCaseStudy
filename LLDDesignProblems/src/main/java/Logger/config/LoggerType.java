package Logger.config;

import Logger.Logger;


public enum LoggerType {
    INFO(1), DEBUG(2), ERROR(3);
    private int level;
    LoggerType(int level) {
        this.level = level;
    }
    public int getLevel() {
        return level;
    }
}
