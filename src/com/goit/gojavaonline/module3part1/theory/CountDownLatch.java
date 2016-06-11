package com.goit.gojavaonline.module3part1.theory;

/**
 * Created by tamila on 6/6/16.
 */
public class CountDownLatch {
    private int counter = 0;
    private final Object lock = new Object();

    public CountDownLatch(int counter) {
        this.counter = counter;
    }

    public void await() throws InterruptedException {
        /*while (true) {
            synchronized (lock) {
                if (counter > 0) {
                    lock.wait();
                } else {
                    lock.notify();
                    break;
                }
            }
        }*/
        synchronized(lock) {
            if (counter > 0) {
                lock.wait();
            }
        }
    }

    public void countDown() {
        synchronized (lock) {
            if (counter > 0) {
                counter--;
                System.out.println("Counter == " + counter);
            }
            if (counter == 0) {
                //lock.notify();
                lock.notifyAll();
            }
        }
    }

    public int getCounter() {
        synchronized (lock){
            return counter;
        }
    }
}
