package pattern.Task4Strategy;

public class Main {
    public static void main(String[] args) {
        Logger consoleLogger = new Logger(new ConsoleLogger());
        consoleLogger.write("consolelogger");
        Logger fileLogger = new Logger(new FileLogger());
        fileLogger.write("filelogger");
        Logger timeFileLogger = new Logger();
        timeFileLogger.setLogger(new TimeFileLogger());
        timeFileLogger.write("timeFileLogger");
    }
}
