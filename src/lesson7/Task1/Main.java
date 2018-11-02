package lesson7.Task1;

public class Main {
    public static void main(String[] args) {
        Pupil pupil = new Pupil(1234);
        String ex[] = {"Математика", "Биология"};
        int marks[] = {2,5};
        pupil.setExams(ex, marks);
        System.out.println(pupil.toString());
    }
}
