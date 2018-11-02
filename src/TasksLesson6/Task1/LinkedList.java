package TasksLesson6.Task1;

public class LinkedList implements Stack {

    private Object first;
    private Object last;
    private Object current;
    private int size;

    public void print(){
        Object j = current;
        Element el = (Element) j;
        while (el != null){
            System.out.println(el.toString() + el.getName());
            el = (Element) el.getNext();
        }
    }

    @Override
    public void push(Object obj) {
        Element e = new Element(obj);
        if(last == null){
            first = e;
            last = e;
            current = e;
            e.setIndex(0);
            e.setNext(null);
            size++;
        }else{
            e.setNext(current); //ссылка на прошлый э хранится в current, присваиваем next
            e.setIndex(e.getIndex() + 1);
            last = e;
            current = e;
            size++;
        }

    }

    @Override
    public void pop() {

    }



}
