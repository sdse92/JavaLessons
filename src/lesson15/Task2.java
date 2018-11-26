package lesson15;


import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;

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
                bout1.write(buf,0,point);
                bout2.write(buf,point,buf.length-point);
            }
        }
    }

    private void glue(File file, File file1, File file2, Charset charset) throws IOException {
        try(InputStream in = new FileInputStream(file1);
        InputStream in1 = new FileInputStream(file2);
        ByteArrayOutputStream bout  = new ByteArrayOutputStream();
        FileOutputStream out = new FileOutputStream(file);
        BufferedOutputStream bos = new BufferedOutputStream(out);
        PrintWriter print = new PrintWriter(new FileOutputStream(file));
        ){
            SequenceInputStream sequenceInputStream = new  SequenceInputStream(in, in1);
            byte[] buf = new byte[1024];
            int len;
            while ((len = sequenceInputStream.read(buf)) > 0){
                bout.write(buf, 0, len);
            }
//            bos.write(buf, 0, buf.length); //записывает только то что во втором файле?
            print.println(new String(bout.toByteArray(), charset));
            System.out.println(new String(bout.toByteArray(), charset));
        }
    }

    public static void main(String[] args) {
        Task2  task = new Task2();
        Scanner sc = new Scanner(System.in);
        System.out.println("введите название файла, который надо разорвать или записать данные");
        File file = new File(sc.nextLine());
        System.out.println("Ведите файл для первой половины разорванного фала или для склеивания");
        File file1 = new File(sc.nextLine());
        System.out.println("Ведите файл для второй половины разорванного фала или для склеивания");
        File file2 = new File(sc.nextLine());

        try {
            task.broke(file, file1, file2, 20, Charset.forName("UTF-8"));
//            task.glue(file, file1, file2, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
