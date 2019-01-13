package lesson22.Task1_Top100;

import java.util.*;
import java.util.concurrent.BlockingQueue;

public class Process {

    private BlockingQueue<String> lines;
    private List<String> linesList;
    private Map<String,Integer> wordCounter = new HashMap<>();
    private final String stop = "STOP";

    public Process(BlockingQueue<String> lines, List<String> linesList) {
        this.lines = lines;
        this.linesList = linesList;
    }

    public void workerTask(){
        String line;
        try {
            while (!(line = lines.take()).equals(stop)) {
            String [] words = line.toLowerCase().replaceAll("pP", "").trim().split(" ");
            for (String word : words){
                if (word.length() > 0) wordCounter.merge(word, 1, (a, b) -> a + b);
            }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printResult(){
        wordCounter.entrySet().stream()
                .sorted(Map.Entry.<String,Integer>comparingByValue().reversed()).limit(100).forEach(System.out::println);
    }
}
