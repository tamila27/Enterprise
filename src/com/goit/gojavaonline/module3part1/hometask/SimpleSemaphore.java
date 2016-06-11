package com.goit.gojavaonline.module3part1.hometask;

import static com.goit.gojavaonline.module3part1.theory.PrintUtility.print;

public class SimpleSemaphore implements Semaphore {
    private final int DEFAULT_MAX_PERMITS_COUNT = 2;

    private final Object lock = new Object();
    private int availablePermits = DEFAULT_MAX_PERMITS_COUNT;
    private int maxPermitsCount = DEFAULT_MAX_PERMITS_COUNT;

    public void setMaxPermitsCount(int permitsCount) {
        maxPermitsCount = permitsCount;
        availablePermits = permitsCount;
    }

    @Override
    public void acquire() throws InterruptedException {
        /*synchronized (lock) {
            if (availablePermits > 0) {
                availablePermits--;
            } else {
                print(" start waiting");
                do {

                    lock.wait();
                } while (availablePermits > 1);
            }
        }*/
        acquire(1);
    }

    @Override
    public void release() {
        release(1);
        /*synchronized (lock) {
            this.availablePermits++;
            lock.notifyAll();
        }*/
    }

    @Override
    public void acquire(int permits) throws InterruptedException {
        /*if (availablePermits == 1) {
            acquire();
        } else {
        }*/
        synchronized (lock) {
            if (this.availablePermits >= permits) {
                this.availablePermits -= permits;
            } else {
                do {
                    print("Before wait() requested permits = " + permits + "; available permits = " + this.availablePermits);
                    lock.wait();
                    print("after wait(): requested permits = " + permits + "; available permits = " + this.availablePermits);
                } while (permits > this.availablePermits);

            }
        }
    }
    /*
    всего 10 пермитов
    th1 = 7, th2 = 3, th3 = 5, th4 = 5, th5 = 5

    1)
     a) th1 -  free = 3, waiting = 0
     b) th3 - put into WAITING state, free = 3, waiting = 1
     c) th2 - free 0, waiting 1
     d) th1 is done, - free = 7, waiting

    2)
     a) th4 - free = 5, waiting 0
     b) th5 - free = 0, waiting 0
     c) th1 - put into WAITING state, free = 0, waiting = 1
     d) th3 - put into WAITING state, free = 0, waiting = 2
     e) th2 - put into WAITING state, free = 0, waiting = 3
     f) th4 - is done, free = 5, waiting 3, notifyAll - waiting = 0
     g) th1 - gets lock ownership, makes sure that there is still not enough permissions and put into WAITING state, free = 5, waiting 1
     */

    @Override
    public void release(int permits) {
        /*if (availablePermits == 1) {
            release();
        } else {
        }*/
        synchronized (lock) {
            if (this.availablePermits + permits > maxPermitsCount) {
                this.availablePermits = maxPermitsCount;
            } else {
                this.availablePermits += permits;
            }
            lock.notifyAll();
        }
    }

    @Override
    public int getAvailablePermits() {
        return this.availablePermits;
    }
}
