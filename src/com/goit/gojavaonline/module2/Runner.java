package com.goit.gojavaonline.module2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tamila on 6/2/16.
 */
public class Runner {
    public static void main(String[] args) throws Exception {
        List<ExamTask> tasks = Arrays.asList(new ExamTask("examTask1", new Student("firstStudent")),
                new ExamTask("examTask2", new Student("secondStudent")));

        test(tasks);

    }

    public static void test(List<ExamTask> tasks) throws Exception {
        Executor<ExamTask, TaskValidator> studentExecutor = new StudentExecutor();

        for (ExamTask task : tasks) {
            studentExecutor.addTask(task);
        }
        Student student = new Student("student3");
        studentExecutor.addTask(new ExamTask("examTask3", student), new TaskValidator());

        studentExecutor.execute();

        System.out.println("Valid results:");
        for (ExamTask task : studentExecutor.getValidResults()) {
            System.out.println(task);
        }
        System.out.println("Invalid results:");
        for (ExamTask task : studentExecutor.getInvalidResults()) {
            System.out.println(task);
        }
    }

}
