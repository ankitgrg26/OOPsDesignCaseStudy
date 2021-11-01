package Logger.config;

import Logger.Logger;
import Logger.config.AppenderType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@JsonIgnoreProperties
public class LoggerConfig {
    LoggerType type;
    List<AppenderType> appenderList;
    String fileAppenderPath;
}
