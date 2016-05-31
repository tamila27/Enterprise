package com.goit.gojavaonline.module1;

/**
 * Created by tamila on 5/27/16.
 */
public class Runner {
    public static void main(String[] args){
        StringBuilder result = new StringBuilder();
        result.append(ExperimentManager.startTest(10000) + "\n");
        result.append(ExperimentManager.startTest(100000) + "\n");
        result.append(ExperimentManager.startTest(1000000));

        String s = result.toString();
        System.out.println(s);
        FileManager.writeToFile("results_module1.txt", s);
    }
}
