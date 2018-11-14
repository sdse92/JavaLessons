package something;

import java.util.Arrays;
import java.util.Scanner;

public class ClientList{



    Client clientList [] = new Client[3];


    public void add() {
        for (int i = 0; i < clientList.length; i++){
            if (clientList[i] == null){
                Scanner sc = new Scanner(System.in);
                System.out.println("Введите имя: ");
                String name = sc.next();
                System.out.println("Введите фамилию: ");
                String surname = sc.next();
                clientList[i] = new Client(name, surname);
                System.out.println(clientList[i]);
                return;
            }
        }
    }


    public void remove(int i) {
        for (int j = 0; j < clientList.length; j++){
            if (j == i){
                clientList[j] = null;
                return;
            }
        }
    }

    public void show(){
        System.out.println(Arrays.toString(clientList));
    }


    public String toString() {
        return "ClientList{" +
                "clientList=" + Arrays.toString(clientList) +
                '}';
    }
}
