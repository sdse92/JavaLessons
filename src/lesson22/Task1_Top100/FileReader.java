package lesson22.Task1_Top100;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    private File file;
    private int stop;

    public FileReader(File file, int stop) {
        this.file = file;
        this.stop = stop;
    }

    public List<String> read(){
        List<String> list = null;
        List<String> word = new ArrayList<>();
        int count = 0;
        int marker = 1;
        try {
            list = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String line : list){
            String [] splitWords = line.toLowerCase().replaceAll("pP", "").trim().split(" ");
            for (String w : splitWords){
                if (w.length() > 0) word.add(w);
            }
            if (list.size()*marker/stop == count){
                word.add("STOP");
                marker++;
            }
            count++;
        }
        word.add("STOP");
        return word;
    }

//    public List<String> readFile(){
//        List<String> list = null;
//        int count = 0;
//        int marker = 1;
//        try {
//            list = Files.readAllLines(file.toPath());
//            for (String s : list){
//                if (list.size()*marker/stop == count){
//                    list.add("STOP");
//                    marker++;
//                }
//                count++;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
}
