package lesson15;

import java.io.*;
import java.nio.charset.Charset;

/*
a) Зашифровать/ дешифровать файл паролем (XOR) (посмотреть в интернете)
b) Зашифровать/ дешифровать файл другим файлом
 */
public class Task3 {
    private void encodeByKey(File file, String pKey, Charset charset) throws IOException {
        try(InputStream in = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream  = new ByteArrayOutputStream();
            FileOutputStream out = new FileOutputStream(file);
            BufferedOutputStream bout = new BufferedOutputStream(out);)
        {
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0){
                byteArrayOutputStream.write(buf,0,len);
            }
            //шифрование
            byte[] key = pKey.getBytes();
            byte[] res = new byte[buf.length];
            for (int i = 0; i < buf.length; i++){
                res[i] = (byte) (buf[i] ^ key[i % key.length]);
            }
            bout.write(res,0,res.length);
        }
    }

    private void encodeByFile(File file, File file2, Charset charset) throws IOException {
        try(InputStream in = new FileInputStream(file);
            InputStream in2 = new FileInputStream(file2);
            ByteArrayOutputStream byteArrayOutputStream  = new ByteArrayOutputStream();
            FileOutputStream out = new FileOutputStream(file);
            BufferedOutputStream bout = new BufferedOutputStream(out);)
        {
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0){
                byteArrayOutputStream.write(buf,0,len);
            }

            byte[] buf2 = new byte[1024];
            int len2;
            while ((len2 = in2.read(buf2)) > 0){
                byteArrayOutputStream.write(buf2,0,len2);
            }
            //шифрование
            byte[] res = new byte[buf.length];
            for (int i = 0; i < buf.length; i++){
                res[i] = (byte) (buf[i] ^ buf2[i % buf2.length]);
            }
            bout.write(res,0,res.length);
        }
    }

    private void decodeByKey(File file, String pKey, Charset charset) throws IOException {
        try(InputStream in = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream  = new ByteArrayOutputStream();
            FileOutputStream out = new FileOutputStream(file);
            BufferedOutputStream bout = new BufferedOutputStream(out);)
        {
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0){
                byteArrayOutputStream.write(buf,0,len);
            }
            //дешифрование
            byte[] res = new byte[buf.length];
            byte[] key = pKey.getBytes();
            for (int i = 0; i < buf.length; i++){
                res[i] = (byte) (buf[i] ^ key[i % key.length]);
            }
            bout.write(res,0,res.length);
        }
    }

    private void decodeByFile(File file, File file2, Charset charset) throws IOException {
        try(InputStream in = new FileInputStream(file);
            InputStream in2 = new FileInputStream(file2);
            ByteArrayOutputStream byteArrayOutputStream  = new ByteArrayOutputStream();
            FileOutputStream out = new FileOutputStream(file);
            BufferedOutputStream bout = new BufferedOutputStream(out);)
        {
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0){
                byteArrayOutputStream.write(buf,0,len);
            }

            byte[] buf2 = new byte[1024];
            int len2;
            while ((len2 = in2.read(buf2)) > 0){
                byteArrayOutputStream.write(buf2,0,len2);
            }
            //дешифрование
            byte[] res = new byte[buf.length];
            for (int i = 0; i < buf.length; i++){
                res[i] = (byte) (buf[i] ^ buf2[i % buf2.length]);
            }
            bout.write(res,0,res.length);
        }
    }

    public static void main(String[] args) {
        Task3 encode = new Task3();
        File file = new File("file.txt");
        File file2 = new File("file2.txt");
        try {
//            encode.encodeByKey(file, "шифр", Charset.forName("UTF-8"));
//            encode.decodeByKey(file, "шифр", Charset.forName("UTF-8"));
//            encode.encodeByFile(file, file2, Charset.forName("UTF-8"));
            encode.decodeByFile(file, file2, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
