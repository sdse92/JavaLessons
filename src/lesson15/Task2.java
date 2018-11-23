package lesson15;


import java.io.*;
import java.nio.charset.Charset;

/*
Разбить/склеить файл (имена файлов и размер куска задаются с клавиатуры).
 */
public class Task2 {
    private void broke(File file, File file1, File file2, int point, Charset charset) throws IOException {
        try(InputStream in = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream  = new ByteArrayOutputStream();
            FileOutputStream out1 = new FileOutputStream(file1);
            BufferedOutputStream bout1 = new BufferedOutputStream(out1);
            FileOutputStream out2 = new FileOutputStream(file2);
            BufferedOutputStream bout2 = new BufferedOutputStream(out2);)
        {
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0){
                byteArrayOutputStream.write(buf,0,len);
            }
            String s = new String(byteArrayOutputStream.toByteArray());
            byte[] numberOfCopyedBytes = s.getBytes(charset);
            int i = numberOfCopyedBytes.length;
            //-------------------------------------------------------------------------------------
            //запись массива байт в другой файл
            if (point > i){
                System.out.println("Введенное количество байт превышает размер файла");
            }else{
                int a = i - point;
                int b = i - a;
                bout1.write(buf,0,a);
//                bout2.write(buf,point + 1,buf.length);
            }
        }
    }

    public static void main(String[] args) {
        Task2  task = new Task2();
        File file = new File("file.txt");
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");

        try {
            task.broke(file, file1, file2, 209, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
