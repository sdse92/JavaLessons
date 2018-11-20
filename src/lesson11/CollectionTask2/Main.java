package lesson11.CollectionTask2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List task = new List();
        Scanner sc = new Scanner(System.in);
        int counter = 0;
        while (true){
            String s = sc.nextLine();
            if (s.equals("print")) task.printList();
            //if (s.equals("printList"))
            else {
                task.put(s);
                counter++;
            }
            if (counter > 3) break;
        }
    }
}
