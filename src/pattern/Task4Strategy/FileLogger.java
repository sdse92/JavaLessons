package pattern.Task4Strategy;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements ILogger {
    @Override
    public void write(String message) {
        try {
            FileWriter fr = new FileWriter("C://Users/SD/Desktop/JavaLessons/src/pattern/Task4Strategy/fileLogger.txt");
            fr.write(message);
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
