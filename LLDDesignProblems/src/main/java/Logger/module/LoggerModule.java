package Logger.module;

import Logger.*;
import Logger.*;
import Logger.config.LoggerConfig;
import Logger.config.LoggerType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

import java.io.IOException;
import java.io.InputStream;

public class LoggerModule extends AbstractModule {
    @Override
    protected void configure() {

    }

    @Provides
    @Singleton
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }

    @Provides
    @Singleton
    public LoggerConfig getLoggerConfig(ObjectMapper mapper) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("logger.json");
        LoggerConfig config = mapper.readValue(inputStream, LoggerConfig.class);
        inputStream.close();
        return config;
    }

    @Provides
    @Singleton
    public LoggerManager getLoggerManager(LoggerConfig config) {
        return new LoggerManager(config);
    }

}
