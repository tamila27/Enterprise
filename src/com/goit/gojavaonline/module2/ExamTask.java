package com.goit.gojavaonline.module2;

import java.util.List;

/**
 * Created by tamila on 6/4/16.
 */
public class ExamTask implements Task<Student> {
    private String examTask;
    private Student student;

    public ExamTask(String examTask, Student student) {
        this.examTask = examTask;
        this.student = student;
    }

    @Override
    public void execute() {
        System.out.println("ExamTasks execute method has been call");
        student.implementExamTask(examTask);
    }

    @Override
    public Student getResult() {
        return student;
    }

    public String getExamTask() {
        return examTask;
    }

    public void setExamTask(String examTask) {
        this.examTask = examTask;
    }

    @Override
    public String toString() {
        return "ExamTask{" +
                "examTask='" + examTask + '\'' +
                ", student=" + student +
                '}';
    }
}
