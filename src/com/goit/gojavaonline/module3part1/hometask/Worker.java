package com.goit.gojavaonline.module3part1.hometask;

import static com.goit.gojavaonline.module3part1.theory.PrintUtility.print;

/**
 * Created by tamila on 6/11/16.
 */
public class Worker implements Runnable {
    private final int STEPS_COUNT = 10;
    private boolean adder;
    private Semaphore semaphore;
    private int count = 0;
    private int permitsRequired;

    public Worker(Semaphore semaphore, boolean adder, int permitsRequired) {
        this.adder = adder;
        this.semaphore = semaphore;
        this.permitsRequired = permitsRequired;
    }

    @Override
    public void run() {
        print("permitsRequired = " + permitsRequired);
        try {
            semaphore.acquire(permitsRequired);
            for (int i = 0; i < STEPS_COUNT; i++) {
                count++;
                print(String.valueOf(count));
            }
            //Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(permitsRequired);
        }

    }
}
