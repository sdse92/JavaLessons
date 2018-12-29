package lesson22.Task1_Top100;


public class Worker implements Runnable{

    Process process;

    public Worker(Process process) {
        this.process = process;
    }

    @Override
    public void run() {
        process.workerTask();
    }
}
