package lesson22.Task1_Top100;


public class Worker implements Runnable{

    WordStorage wordStorage;

    public Worker(WordStorage wordStorage) {
        this.wordStorage = wordStorage;
    }

    @Override
    public void run() {
        wordStorage.getWord();
    }
}
