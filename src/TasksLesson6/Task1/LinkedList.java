package TasksLesson6.Task1;

public class LinkedList extends Object implements Stack {

    private Object first;
    private Object last;

    public LinkedList(Object obj, int index) {
        super(obj, index);
    }


    @Override
    public void push(Object obj) {
        Object n = new Object(obj, setIndex(););

    }

    @Override
    public void pop() {

    }
}
