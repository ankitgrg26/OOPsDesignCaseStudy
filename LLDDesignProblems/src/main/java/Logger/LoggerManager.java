package Logger;

import Logger.config.LoggerConfig;
import Logger.config.LoggerType;
import Logger.module.LoggerModule;
import coffee.machine.module.CoffeeMachineModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class LoggerManager {
    LoggerConfig loggerConfig;
    LoggerChain head;

    public LoggerManager(LoggerConfig loggerConfig) {
        this.loggerConfig = loggerConfig;
        LoggerChain filter = new LoggerFilter(loggerConfig.getType());
        LoggerChain decorator = new LoggerDecorator();
        LoggerChain appender = new ConsoleAppender();
        filter.setNextChain(decorator);
        decorator.setNextChain(appender);
        this.head = filter;
    }

    public LoggerContext getLoggerContext(Class t) {
        LoggerContext logger = new LoggerContext(t.getName());
        logger.setNextChain(head);
        return logger;
    }


    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new LoggerModule());

    }
}
