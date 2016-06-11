package com.goit.gojavaonline.module3part1.hometask;

/**
 * Created by tamila on 6/6/16.
 */
public class Runner {

    private static final int PERMITS_COUNT = 3;
    private static  final int THREADS_COUNT = 5;

    public static void main(String[] args) {
        SimpleSemaphore semaphore = new SimpleSemaphore();
        semaphore.setMaxPermitsCount(PERMITS_COUNT);

        for (int i = 0; i < THREADS_COUNT; i++) {
            new Thread(new Worker(semaphore, true, getPermitsRequired())).start();
        }
    }

    private static int getPermitsRequired() {
        return 1 + ((int) (Math.random() * (PERMITS_COUNT - 1)));
    }
}
