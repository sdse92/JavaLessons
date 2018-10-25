package lesson4.Task2;

public class List {
    private Node head;
    private Node tail;

    public void add(int i){
        Node n = new Node();
        n.i = i;
        if(tail == null){
            head = n;
            tail = n;
        }else{
            tail.next = n;
            tail = n;
        }
    }

    public void remove(int i){
        if(head == null)
            return;
        if(head == tail){
            head = null;
            tail = null;
            return;
        }
        if(head.i == i){
            head = head.next;
            return;
        }

        Node j = head;
        while (j.next != null){
            if (j.next.i == i){
                if(tail == j.next)
                {
                    tail = j;
                }
                j.next = j.next.next;
                return;
            }
            j = j.next;
        }
        }

        public void show(){
           Node j = head;
            while (j != null)
            {
                System.out.print(j.i + " ");
                j = j.next;
            }
    }
}
