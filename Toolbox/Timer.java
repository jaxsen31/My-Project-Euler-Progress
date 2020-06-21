package Toolbox;

import java.util.Date;

public class Timer extends Thread{
    private Date start;
    private static volatile boolean isStopped = false;
    private int time = 1;

    public Timer() {
        System.out.println("Start");
        this.start = new Date();
        start();
    }

    public void run(){
        try {
            while (!isStopped) {
                Thread.sleep(1000);
                System.out.println(time + "s have passed");
                time++;
            }
        } catch (InterruptedException e) {
        }
    }

    public void end(){
        this.interrupt();
        Date end = new Date();
        System.out.println(end.getTime() - start.getTime() + "ms");
    }
}
