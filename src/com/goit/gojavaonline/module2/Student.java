package com.goit.gojavaonline.module2;

/**
 * Created by tamila on 6/4/16.
 */
public class Student {
    private String name;
    private String taskImplementation;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void implementExamTask(String examTask){
        taskImplementation = String.format("Sudent %s implemented task %s", name, examTask);
        System.out.println("implementing examTask");
    }

    public boolean examTaskImplemented(){
        return !taskImplementation.isEmpty();
    }
}
