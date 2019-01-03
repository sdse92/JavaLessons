package diplom;

import java.util.Date;

public class Timer {

    Date date = new Date();
    private long actualTime = date.getTime();
    private long timeFrom = 1544511600;
    private long timeTo = 1544518800;


    public long getTimeFrom() {
        return timeFrom;
    }

    public long getTimeTo() {
        return timeTo;
    }
}
