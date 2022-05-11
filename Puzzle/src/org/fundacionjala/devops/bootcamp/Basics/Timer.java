package org.fundacionjala.devops.bootcamp.Basics;

public class Timer extends Thread {
    private int minutes;
    private int seconds;

    @Override
    public void run (){

        for (int min = (minutes-1); min > 0; min--) {
            for (int sec = 59; sec > 0; sec--) {
                seconds = sec;
                // remove commented code
//                System.out.println(sec);
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){

                }
            }
            minutes = min;
        }
    }
    // use this. is much better (like in setters methods)
    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes-1;
    }

    // remove this function if is not needed anymore
    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
}
