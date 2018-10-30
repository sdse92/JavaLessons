package TasksLesson6.Task2;

abstract public class File {
    private String key;
    private String inf;

    public File(String key, String inf) {
        this.key = key;
        this.inf = inf;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getInf() {
        return inf;
    }

    public void setInf(String inf) {
        this.inf = inf;
    }

    abstract public String read();

    abstract public String write();
}
