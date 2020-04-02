package com.company;

public class Daemon implements Runnable {

    private long timer;
    private long maxTimer;

    @Override
    public void run() {
      //  this.setDaemon(true);
        while(getTimer() > 0){
            setTimer();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
        Board.stop = 1;
        System.out.println("Time out!");
    }

    public synchronized long getTimer() {
        return timer;
    }

    public void setTimer() {
        this.timer--;
    }

    public Daemon(long maxTimer) {
        this.maxTimer = maxTimer;
        this.timer = maxTimer;
    }
}
