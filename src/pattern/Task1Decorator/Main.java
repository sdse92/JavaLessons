package pattern.Task1Decorator;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String password = "superKey";
        try {
            InputStream in = new CryptoInputStream(new FileInputStream("file.txt"), password);
            OutputStream out = new CryptoOutputStream(new FileOutputStream("file.txt"), password);
//            System.out.println((char) in.read());
            while (in.available() > 0){
                out.write(in.read());
                out.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
