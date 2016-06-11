package com.goit.gojavaonline.module3part1.theory;

/**
 * Created by tamila on 6/8/16.
 */
public class VolatileEample {
    private volatile static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Worker()).start();
        Thread.sleep(100);
        flag = false;
        System.out.println(flag);

    }

    public static class Worker implements Runnable{
        @Override
        public void run() {
            int i = 0;
            while (flag){
                i++;
            }
            System.out.println(i);
        }
    }

    public class Test {

        private  int  counter = 0;
        private   final Object lock = new Object();

        public  void  await() throws InterruptedException {
            synchronized (lock){
                if (counter > 0) {
                    lock.wait();
                }
            }
        }
    }
}
