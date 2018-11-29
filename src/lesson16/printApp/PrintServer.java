package lesson16.printApp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class PrintServer {
    private int port;




    public PrintServer(int port){
        this.port = port;
    }

    private void getMessage(Socket socket){
        try (ObjectInputStream objIn = new ObjectInputStream(socket.getInputStream())){
            Object object = objIn.readObject();
            printMessage((Message)object);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void printMessage(Message message){
        System.out.println("message: " + message.getMessText() + " from " + message.getSender());
    }

    public void start(){
        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server started on:" + serverSocket);
            Scanner scanner = new Scanner(System.in);
            while (true){
                Socket socket = serverSocket.accept();
                getMessage(socket);
                String s = scanner.nextLine();
                if (s.equals("server time")){
                    Date date = new Date();
                    System.out.println(date.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);
        PrintServer server = new PrintServer(port);
        server.start();
    }
}
