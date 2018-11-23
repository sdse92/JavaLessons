package lesson15;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Scanner;

/*
Скопировать файл (имена файлов задаются с клавиатуры).
Программа должна выводить количество скопированных байт.
 */
public class Task1 {

    //чтение массивом байт из файла который копируют
    private int readFile(File fileForRead, File fileForWrite, Charset charset) throws IOException {
        try(InputStream in = new FileInputStream(fileForRead);
            ByteArrayOutputStream byteArrayOutputStream  = new ByteArrayOutputStream();
            FileOutputStream out = new FileOutputStream(fileForWrite);
            BufferedOutputStream bout = new BufferedOutputStream(out);)
        {
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0){
                byteArrayOutputStream.write(buf,0,len);
            }
            System.out.println(len);
            String s = new String(byteArrayOutputStream.toByteArray());
            byte[] numberOfCopyedBytes = s.getBytes(charset);
            int i = numberOfCopyedBytes.length;
        //-------------------------------------------------------------------------------------
        //запись массива байт в другой файл

            bout.write(buf,0,buf.length);
            return i;
        }
    }

    public String fileFormat (String s){
        String check = "[^.txt]";
        String giveBack = null;
        if (s.replaceAll(check,"").equals(".txt")){
            giveBack = s;
        }else{
            giveBack = "Файл должен быть в формате .txt";
        }
        return giveBack;
    }


    public static void main(String[] args) {
        Task1 copy = new Task1();
        Scanner sc = new Scanner(System.in);
        System.out.println("Файл который надо скопировать: ");
//        String a = copy.fileFormat(sc.nextLine());
//        System.out.println(a);
        File fileToCopy = new File(sc.nextLine());
        System.out.println("Файл в который надо скопировать: ");
        File fileCopy = new File(sc.nextLine());


        try {
            System.out.println(copy.readFile(fileToCopy, fileCopy, Charset.forName("UTF-8")));
        } catch (FileNotFoundException e){
            System.out.println("Файл с таким именем не найден");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class FormatException extends Exception{

}