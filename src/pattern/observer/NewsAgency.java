package pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class NewsAgency {
    private List<Listener> listeners = new ArrayList<>();

    public void add(Listener listener){
        listeners.add(listener);
    }

    public void deleteListner(Listener listener){
        listeners.remove(listener);
    }

    public void newMessage(String mess){
        System.out.println("Message " + mess);
        notifyListeners(mess);
    }

    private void notifyListeners(String mess){
        for(Listener listener : listeners){
            listener.publish(mess);
        }
    }

    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();

        newsAgency.add(new Listener() {
            @Override
            public void publish(String str) {
                System.out.println("listner 1: " + str);
            }
        });

        newsAgency.add(new Listener() {
            @Override
            public void publish(String str) {
                System.out.println("listner 2: " + str);
            }
        });

        newsAgency.newMessage("some changes");
    }
}
