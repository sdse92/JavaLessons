package TasksLesson6.Task1;

public class LinkedList implements Stack, Queue, List {

    private Element first;
    private Element last;
    private Element current;
    private int size;

    public void print(){
        Element el = last;
        while (el != null){
            System.out.println(el.toString());
            el = el.getNext();
        }
    }

    @Override
    public void push(Object obj) {  //добавление в конец списка
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
            e.setIndex(current.getIndex() + 1);
            last = e;
            current = e;
            size++;
        }

    }

    @Override
    public void pop() {     //удаление последнего в списке эл-та
        current = current.getNext();
        last = last.getNext();
        size--;
    }


    @Override
    public void shift(Object obj) {     //добавление в начало списка
        Element e = new Element(obj);
        if(first == null){
            first = e;
            last = e;
            current = e;
            e.setIndex(0);
            e.setNext(null);
            size++;
        }else{
            e.setNext(null);
            Element i = last;
            while (i != null){
                i.setIndex(i.getIndex() + 1);
                if (i.getNext() == null){
                    i.setNext(e);
                    size++;
                    break;
                }
                i = i.getNext();
            }
        }
    }

    @Override
    public void unshift() {     //удаление первого элемента в списке
        Element e = last;
        while (e != null){
            e.setIndex(e.getIndex() - 1);
            if (e.getNext().getNext() == null){
                e.setNext(null);
                size--;
                break;
            }
            e = e.getNext();
        }
    }

    @Override
    public void add(Object obj, int index) {
        Element e = new Element(obj);
        Element i = last;
        if(first == null){
            first = e;
            last = e;
            current = e;
            e.setIndex(0);
            e.setNext(null);
            size++;
            return;
        }
        if (index == 0){
            shift(obj);
            return;
        }
        if (last.getIndex() == index){
            push(obj);
            return;
        }
        while (i != null){
            if (i.getNext().getIndex() == index){
                e.setNext(i.getNext().getNext());
                Element j = last;
                while (j.getIndex() >= index){
                    j.setIndex(j.getIndex() +1);
                    j = j.getNext();
                }
                e.setIndex(index);
                i.getNext().setNext(e);
                size++;
                break;
            }
            i = i.getNext();
        }
    }

    @Override
    public void remove(int index) {
        Element i =last;
        if (index == 0){
            unshift();
            return;
        }
        if (last.getIndex() == index){
            pop();
            return;
        }
        while (i != null){
            if (i.getNext().getIndex() == index){
                i.setNext(i.getNext().getNext());
                Element j = last;
                while (j.getIndex() >= index){
                    j.setIndex(j.getIndex() - 1);
                    j = j.getNext();
                }
                size--;
                break;
            }
            i = i.getNext();
        }
    }

    @Override
    public Object get(int index) {
        Element e = last;
        Element element = null;
        while (e != null){
            if (index == e.getIndex()){
                element = e;
                break;
            }
            e = e.getNext();
        }
        System.out.println(element.toString());
        return element;
    }

    @Override
    public int size() {
        System.out.println(size);
        return size;
    }
}
