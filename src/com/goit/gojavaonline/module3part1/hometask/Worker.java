package com.goit.gojavaonline.module3part1.hometask;

import static com.goit.gojavaonline.module3part1.hometask.PrintUtility.print;

/**
 * Created by tamila on 6/11/16.
 */
public class Worker implements Runnable {
    private static final int STEPS_COUNT = 10;
    private Semaphore semaphore;
    private int permitsRequired;

    public Worker(Semaphore semaphore, int permitsRequired) {
        this.semaphore = semaphore;
        this.permitsRequired = permitsRequired;
    }

    @Override
    public void run() {
        print("permitsRequired = " + permitsRequired);
        try {
            semaphore.acquire(permitsRequired);
            for (int i = 0; i < STEPS_COUNT; i++) {
                print(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace(System.err);
        } finally {
            semaphore.release(permitsRequired);
        }

    }
}
