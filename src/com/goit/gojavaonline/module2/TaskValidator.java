package com.goit.gojavaonline.module2;

/**
 * Created by tamila on 6/4/16.
 */
public class TaskValidator implements Validator<Task<Student>> {
    @Override
    public boolean isValid(Task result) {
        result.execute();
        if(((Student)result.getResult()).examTaskImplemented()){
            return true;
        }
        return false;
    }
}
