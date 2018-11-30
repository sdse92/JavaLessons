package lesson16.fileTasks;


import java.io.*;
import java.util.Arrays;

/*
Написать программу, которая копирует файлы из одного каталога в другой
(имена каталогов задаются при запуске программы)
 */
public class Task3 {
    public void copy(String path1, String path2) throws IOException {
        File from = new File(path1);
        File to = new File(path2);
        to.mkdir();
        StringBuilder sb = new StringBuilder();
        byte[] rez = null;
        String[] list = from.list();
        for (String s : list){
            File x = new File(path1 + "/" + s);
            if (x.isFile()){
                File copy = new File(x.getName());
                copy.createNewFile();
                try(InputStream in = new FileInputStream(x);
                    ByteArrayOutputStream byteArrayOutputStream  = new ByteArrayOutputStream())
                {
                    byte[] buf = new byte[1024];
                    int len;
                    while ((len = in.read(buf)) > 0){
                        byteArrayOutputStream.write(buf,0,len);
                    }
                    String rezToString = new String(byteArrayOutputStream.toByteArray());
                    String[] rezToStringArray = rezToString.split("");
                    for (String j : rezToStringArray){
                        sb.append(j);
                    }
                    rez = sb.toString().getBytes();
                    FileOutputStream fout = new FileOutputStream(path2 + "/" + x.getName());
                    fout.write(rez);
                }
            }
        }

    }

    public static void main(String[] args) {
        Task3 task3 = new Task3();
        String path1 = "C://Users/SD/Desktop/JavaLessons/src/lesson16/fileTasks/forTask1";
        String path2 = "C://Users/SD/Desktop/JavaLessons/src/lesson16/fileTasks/forTask3";
        try {
            task3.copy(path1, path2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
