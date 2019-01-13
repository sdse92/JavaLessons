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

    public List<String> readFile(){
        List<String> list = null;
        List<String> lines = new ArrayList<>();
        int count = 0;
        int marker = 1;
        try {
            list = Files.readAllLines(file.toPath());
            for (String s : list){
                lines.add(s);
                if (list.size()*marker/stop == count){
                    lines.add("STOP");
                    marker++;
                }
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        lines.add("STOP");
        return lines;
    }
}
