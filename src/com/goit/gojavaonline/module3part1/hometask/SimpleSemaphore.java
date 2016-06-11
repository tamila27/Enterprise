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
        acquire(1);
    }

    @Override
    public void release() {
        release(1);
    }

    @Override
    public void acquire(int permits) throws InterruptedException {
        if (permits > 0) {
            synchronized (lock) {
                if (availablePermits >= permits) {
                    availablePermits -= permits;
                } else {
                    do {
                        print("Before wait(): requested permits = " + permits + "; available permits = " + availablePermits);
                        lock.wait();
                        print("after wait(): requested permits = " + permits + "; available permits = " + availablePermits);
                    } while (permits > availablePermits);
                }
            }
        } else {
            print("[acquire()] : Wrong parameter value, permits = " + permits);
        }
    }

    @Override
    public void release(int permits) {
        if (permits > 0) {
            synchronized (lock) {
                if (availablePermits + permits > maxPermitsCount) {
                    availablePermits = maxPermitsCount;
                } else {
                    availablePermits += permits;
                }
                lock.notifyAll();
            }
        } else {
            print("[release()] : Wrong parameter value, permits = " + permits);
        }
    }

    @Override
    public int getAvailablePermits() {
        return this.availablePermits;
    }
}
