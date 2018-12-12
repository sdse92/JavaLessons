package pattern.Task4Strategy;

public class ConsoleLogger implements ILogger {
    @Override
    public void write(String message) {
        System.out.println(message);
    }
}
