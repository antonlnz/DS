package e2;

import java.time.LocalTime;
public class Hour {
    private int hour;

    private int minutes;

    private int seconds;

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public Hour(){
        LocalTime time = LocalTime.now();
        this.hour = time.getHour();
        this.minutes = time.getMinute();
        this.seconds = time.getSecond();
    }
    @Override
    public String toString() {
        return hour + ":" + minutes + ":" + seconds ;
    }

}