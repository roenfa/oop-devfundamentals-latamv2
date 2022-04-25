package org.fundacionjala.devops.bootcamp.Basics;

public class Timer extends Thread{
    private int minutes;
    private int seconds;
    private int level;

    public Timer(int level){
        this.level=level-1;
    }


    public void run (){

        minutes=level;

        for (int min = level; min > 0; min--) {
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


}
