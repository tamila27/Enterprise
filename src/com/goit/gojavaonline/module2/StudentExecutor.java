package com.goit.gojavaonline.module2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tamila on 6/4/16.
 */
public class StudentExecutor implements Executor<ExamTask, TaskValidator> {
    private List<ExamTask> validTasks;
    private List<ExamTask> inValidTasks;
    private boolean executed;

    public StudentExecutor() {
        validTasks = new ArrayList<>();
        inValidTasks = new ArrayList<>();
    }

    @Override
    public void addTask(ExamTask task) throws Exception {
        if(executed){
            throw new Exception("StudentExecutor has been executed");
        }
        validTasks.add(task);
    }

    @Override
    public void addTask(ExamTask task, TaskValidator validator) throws Exception {
        if(executed){
            throw new Exception("StudentExecutor has been executed");
        }
        if(validator.isValid(task)){
           validTasks.add(task);
        } else {
            inValidTasks.add(task);
        }
    }

    @Override
    public void execute() {
        executed = true;
        System.out.println("Execute method");
    }

    @Override
    public List getValidResults() throws Exception {
        if(executed){
            return validTasks;
        } else {
            throw new Exception("There are no executed tasks");
        }
    }

    @Override
    public List getInvalidResults() throws Exception {
        if(executed){
            return inValidTasks;
        } else {
            throw new Exception("There are no executed tasks");
        }
    }
}
