package org.fundacionjala.devops.bootcamp.Basics;

public class Timer extends Thread{
    private int minutes;
    private int seconds;


    @Override
    public void run (){

        for (int min = (minutes-1); min > 0; min--) {
            for (int sec = 59; sec > 0; sec--) {
                seconds = sec;
//                System.out.println(sec);
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){

                }
            }
            minutes = min;
        }
    }
    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes-1;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
}
