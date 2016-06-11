package com.goit.gojavaonline.module3part1.theory;

/**
 * Created by tamila on 6/6/16.
 */
public class Runner {
    private CountDownLatch countDownLatch;

    public void test() {
        countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(new Worker()).start();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (countDownLatch.getCounter() > 0) {
                    countDownLatch.countDown();
                }
            }
        }).start();
    }

    public class Worker implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " start waiting");
                countDownLatch.await();
                System.out.println("Thread " + Thread.currentThread().getName() + " stop waiting");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
