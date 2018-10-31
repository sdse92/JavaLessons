package TasksLesson6.Task1;

public class Object {
    private Object obj;
    private int index;

    public Object(Object obj, int index) {
        this.obj = obj;
        this.index = index;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
