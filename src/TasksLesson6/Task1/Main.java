package TasksLesson6.Task1;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.push("one");
        list.push("two");
        list.push("three");
        //list.print();
        //list.pop();

        list.add("four", 1);
        list.remove(2);
//        list.print();
//        list.unshift();
//        list.get(1);
        list.print();
        list.size();
    }
}
