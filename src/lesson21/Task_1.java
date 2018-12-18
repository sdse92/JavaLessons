package lesson21;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Необходимо выполнить подсчет топ 100 слов параллельно.
Количество потоков должно быть равно числу доступных процессоров в системе (Runtime.getRuntime().availableProcessors()).
Каждый поток собирает свой результат (Map), а потом сливает в общий (Map).
Первый поток, который создавал другие треды должен ожидать их завершения с помощью метода join() и выводить результат.
 */
public class Task_1 {
    private String fileReader(String fileName){
        String formBuf = null;
        try (InputStream in = new FileInputStream(fileName);
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            //читаем файл
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                byteArrayOutputStream.write(buf, 0, len);
            }
            formBuf = new String(byteArrayOutputStream.toByteArray());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return formBuf;
    }

    private int avaliableProc(){
        int proc = Runtime.getRuntime().availableProcessors();
        return proc;
    }

        public static void main(String[] args) {
        Task_1 task = new Task_1();
        System.out.println(task.fileReader("file.txt"));

        }
}

class FileExplorer extends Thread{
    Task_1 task1 = new Task_1();
    @Override
    public void run() {
        int coutn = 0;
//        List<String> list = task1;

    }
}