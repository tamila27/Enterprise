package com.goit.gojavaonline.module2;

/**
 * Created by tamila on 6/2/16.
 */
public class Runner {
    public static void main(String[] args){
        Number[] intNumbers = new Integer[]{10, 20, 30};
        intNumbers[2] = 10.48;
        for (Number intNumber : intNumbers) {
            System.out.println(intNumber);
        }

        
    }

    /*public void test(List<Task<Integer>> intTasks) {
        Executor<Number> numberExecutor = new ExecutorImpl<>();

        for (Task<Integer> intTask : intTasks) {
            numberExecutor.addTask(intTask);
        }
        numberExecutor.addTask(new LongTask(10L), new NumberValidator());

        numberExecutor.execute();

        System.out.println("Valid results:");
        for (Number number : numberExecutor.getValidResults()) {
            System.out.println(number);
        }
        System.out.println("Invalid results:");
        for (Number number : numberExecutor.getInvalidResults()) {
            System.out.println(number);
        }
    }*/

}
