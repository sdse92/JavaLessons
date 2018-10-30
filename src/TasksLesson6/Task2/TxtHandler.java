package TasksLesson6.Task2;

public class TxtHandler extends File {
    public TxtHandler(String key, String inf) {
        super(key, inf);
    }

    @Override
    public String read() {
        return this.getKey();
    }

    @Override
    public String write() {
        return this.getKey() + this.getInf();
    }
}
