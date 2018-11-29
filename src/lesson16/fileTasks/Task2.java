package lesson16.fileTasks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;

/*
Написать программу, которая создает текстовый файл и записывает в него список файлов из заданного каталога.
Программа запускается с параметром: имя каталога.

Информацию о файлах записывать следующим образом:
информация по каждому файлу записывается с новой строки и содержит:
путь к файлу, имя файла, дата создания файла (если сами не найдете, как узнать дату создания файла, пишите)
 */
public class Task2 {
    public void stat(String addr) throws IOException {
        File file = new File(addr);
        String [] list = file.list();

//        System.out.println(Arrays.toString(list));
        for (String s : list){
            File x = new File(addr + "/" + s);
            if (x.isFile() == true) {
                System.out.print(x.getName() + " | ");
                System.out.print(x.getParent() + " | ");
                Path path = x.toPath();
                BasicFileAttributes att = Files.readAttributes(path, BasicFileAttributes.class);
                System.out.print(att.creationTime());
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        String addr = args[0];
        Task2 task = new Task2();
        try {
            task.stat(addr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
