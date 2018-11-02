package lesson7.Task1;

import java.util.Arrays;

public class Pupil {
    int id;
    ExamResult ExamResult[];

    public Pupil(int id) { this.id = id; }

    ExamResult exres = new ExamResult();

    public void setExams(String[] ex, int[] marks){
        exres.ex = ex;
        exres.marks = marks;
    }

    class ExamResult{
        String ex[];
        int marks[];
        String result[];

        public result(){
            marks = new int[];

        }

        public void setEx(String[] ex) {
            this.ex = ex;
        }

        public void setMarks(int[] marks) {
            this.marks = marks;
        }
    }

    @Override
    public String toString() {
        return "Студент " + id + "\n" +
                "ExamResult=" + Arrays.toString(ExamResult);
    }
}
