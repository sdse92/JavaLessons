package TasksLesson6.Task1;

public class Element {
    private Object name;
    private int index;
    private Element next;

    public Element(Object name) {
        this.name = name;
    }

    public Object getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Element{" +
                "name=" + name +
                ", index=" + index +
                '}';
    }
}
