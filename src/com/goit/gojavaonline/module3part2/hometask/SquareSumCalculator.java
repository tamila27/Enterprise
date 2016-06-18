package com.goit.gojavaonline.module3part2.hometask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

/**
 * Created by tamila on 6/18/16.
 */
public class SquareSumCalculator implements SquareSum, PhaserOwner {
    private final Phaser phaser = new Phaser(1);

    @Override
    public long getSquareSum(int[] values, int numberOfThreads) {

        long result = 0;
        if(values != null) {
            int threadsNumber = Math.min(values.length, numberOfThreads);
            int subArrayLength = values.length / threadsNumber;;
            int extraSubArrayLength = values.length % threadsNumber;
            int subArrayStartIndex = 0;
            int subArrayEndIndex = subArrayLength + extraSubArrayLength - 1;

            ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

            List<SquareSumWorker> squareSumWorkerList = new ArrayList<>();

            for (int i = 0; i < threadsNumber; i++) {
                phaser.register();
                SquareSumWorker squareSumWorker = new SquareSumWorker(values, subArrayStartIndex, subArrayEndIndex, this);
                squareSumWorkerList.add(squareSumWorker);
                executor.execute(squareSumWorker);
                subArrayStartIndex = subArrayEndIndex + 1;
                subArrayEndIndex += subArrayLength;
            }

            arriveAndAwaitAdvance();
            for (int i = 0; i < squareSumWorkerList.size(); i++) {
                result += squareSumWorkerList.get(i).getResult();
            }
            phaser.arriveAndDeregister();
            executor.shutdown();
        }
        return result;
    }

    @Override
    public void arriveAndAwaitAdvance() {
        phaser.arriveAndAwaitAdvance();
    }
}
