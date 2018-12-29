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

    public void workerTask() {
        try {
            String line;
            List<String> threadLines = new ArrayList<>();
            String [] words = null;
            while (!(line = lines.take()).equals(stop)){
                threadLines.add(line);
                for (String localLine : threadLines){
                    words = localLine.toLowerCase().replaceAll("pP", "").trim().split(" ");
                    for (String word : words){
                        if (word.length() > 0){
                            if (wordCounter.isEmpty()){
                                wordCounter.put(word, 0);
                            }else {
                                if (wordCounter.containsKey(word)){
                                    wordCounter.put(word, wordCounter.get(word) + 1);
                                }else{
                                    wordCounter.put(word, 0);
                                }
                            }
                        }
                    }
                }
            }
//            System.out.println(threadLines);
//            System.out.println(Arrays.toString(words));
//            System.out.println(wordCounter);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void printResult(){
        wordCounter.entrySet().stream()
                .sorted(Map.Entry.<String,Integer>comparingByValue().reversed()).limit(100).forEach(System.out::println);
    }
}
