package lesson16.fileTasks;

import java.io.*;
import java.util.Arrays;

/*
Написать программу, которая удаляет из файла все слова, содержащие заданное количество символов
(количество символов задается диапазоном, например 4-6).
Для вывода результатов создавать новую директорию и файл средствами класса File
 */
public class Task1 {

    public void deleteWords(int i){
        StringBuilder sb = new StringBuilder();
        try (InputStream in = new FileInputStream("file.txt");
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ByteArrayOutputStream bout = new ByteArrayOutputStream()) {
            //читаем файл
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                byteArrayOutputStream.write(buf, 0, len);
            }
            //удаляем слова
            String fromBuf = new String(byteArrayOutputStream.toByteArray());
            String [] del = fromBuf.split(" ");
            for (String s : del){
                if (s.length() != i){
                    sb.append(s).append(" ");
                }
            }
            //делаем массив для вывода
            String rez = sb.toString().trim();
            byte[] out = sb.toString().getBytes("UTF-8");
            bout.write(out, 0, out.length);
            //создаем папку и файл для результата
            File filePath = new File("C://Users/SD/Desktop/JavaLessons/src/lesson16/fileTasks/forTask1");
            filePath.mkdir();
            File file = new File("deleteWords.txt");
            file.createNewFile();
            //пишем результат в файл
            FileOutputStream fout = new FileOutputStream("C://Users/SD/Desktop/JavaLessons/src/lesson16/fileTasks/forTask1/deleteWords.txt");
            fout.write(out);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Task1 prog = new Task1();
        prog.deleteWords(3);
    }
}
