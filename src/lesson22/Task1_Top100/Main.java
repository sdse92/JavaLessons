package lesson22.Task1_Top100;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) {
        File file = new File("wp.txt");
        int processCount = Runtime.getRuntime().availableProcessors();
        FileReader fileReader = new FileReader(file, processCount);
        List<String> wordList = fileReader.read();
        BlockingQueue<String> word = new ArrayBlockingQueue<>(wordList.size(), true, wordList);
        WordStorage wordStorage = new WordStorage(word, wordList);
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < processCount; i++){
            threads.add(new Thread(new Worker(wordStorage)));
        }

        for (int i = 0; i < processCount; i++){
            threads.get(i).start();
        }

        for (int i = 0; i < processCount; i++){
            try {
                threads.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        wordStorage.printTop();
    }
}
