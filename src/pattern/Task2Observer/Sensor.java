package pattern.Task2Observer;


import java.util.ArrayList;
import java.util.List;

public class Sensor {
    private int t = 0;
    private List<Alarm> alarms = new ArrayList<>();

    public void start() {
        alarms.add(new Alarm() {
            @Override
            public void tempChange(int temp) {
                if (temp == 100) { System.out.println(temp + " Green"); }
            }
        });
        alarms.add(new Alarm() {
            @Override
            public void tempChange(int temp) {
                if (temp == 300) { System.out.println(temp + " Yellow"); }
            }
        });
        alarms.add(new Alarm() {
            @Override
            public void tempChange(int temp) {
                if (temp == 600) { System.out.println(temp + " Red"); }
            }
        });

        for (t = 0; t <= 600; t++){
            notify(t);
        }
        while (t > 250){
            t--;
            notify(t);
        }
    }

    private void notify(int t){
        for (Alarm alarm : alarms){
            alarm.tempChange(t);
        }
    }

    public static void main(String[] args) {
        Sensor sensor = new Sensor();
        sensor.start();
    }
}
