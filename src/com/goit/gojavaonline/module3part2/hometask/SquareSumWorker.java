package com.goit.gojavaonline.module3part2.hometask;

/**
 * Created by tamila on 6/18/16.
 */
public class SquareSumWorker implements Runnable {
    private int[] array;
    private int startIndex;
    private int endIndex;
    private long result;
    private PhaserOwner phaserOwner;

    public SquareSumWorker(int[] array, int startIndex, int endIndex, PhaserOwner phaserOwner) {
        this.array = array;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.phaserOwner = phaserOwner;
        this.result = 0;
    }

    @Override
    public void run() {
        if(array != null) {
            for (int i = startIndex; i <= endIndex; i++) {
                result += Math.pow(array[i], 2);
            }
        }
        phaserOwner.arriveAndAwaitAdvance();
    }

    public long getResult() {
        return result;
    }
}
