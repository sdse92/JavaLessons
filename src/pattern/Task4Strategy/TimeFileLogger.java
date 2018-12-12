package pattern.Task4Strategy;

import java.util.Date;

public class TimeFileLogger implements ILogger {
    @Override
    public void write(String message) {
        Date time = new Date();
        message += " " + time.toString();
        FileLogger logger = new FileLogger();
        logger.write(message);
    }
}
