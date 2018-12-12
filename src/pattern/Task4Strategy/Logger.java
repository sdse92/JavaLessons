package pattern.Task4Strategy;

public class Logger {
    private  ILogger iLogger;

    public Logger(){
    }

    public Logger(ILogger iLogger){
        this.iLogger = iLogger;
    }

    public void setLogger(ILogger iLogger){
        this.iLogger = iLogger;
    }

    public void write(String message){
        iLogger.write(message);
    }
}
