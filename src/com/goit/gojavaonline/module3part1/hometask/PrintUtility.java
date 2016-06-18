package com.goit.gojavaonline.module3part1.hometask;

/**
 * Created by tamila on 6/11/16.
 */
public class PrintUtility {
    public static void print(String message){
        System.out.println(Thread.currentThread().getName() + " : " + message);
    }

    public static void print(int message){
        print(String.valueOf(message));
    }
}
