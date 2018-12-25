package lesson22.Task1_Top100;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class WordStorage {
    private BlockingQueue<String> word;
    private List<String> wordList;
    private Map<String,Integer> wordCounter;
    private final String stop = "STOP";

    public WordStorage(BlockingQueue<String> word, List<String> wordList) {
        this.word = word;
        this.wordList = wordList;
        wordCounter = new HashMap<>();
        if (wordCounter.isEmpty()) {
            for (String list : wordList) {
                if (!list.equals(stop))
                    wordCounter.put(list, 0);
            }
        }
    }

    public void getWord() {
        try {
            String line;
            while (!(line = word.take()).equals(stop)) {
                for (Map.Entry<String, Integer> map : wordCounter.entrySet()) {
                    if (map.getKey().equals(line)) {
                        map.setValue(map.getValue() + 1);
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void printTop(){
        wordCounter.entrySet().stream()
                .sorted(Map.Entry.<String,Integer>comparingByValue().reversed()).limit(100).forEach(System.out::println);
    }
}
