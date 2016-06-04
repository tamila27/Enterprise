package com.goit.gojavaonline.module2;

/**
 * Created by tamila on 6/2/16.
 */
public interface Task<T> {
    // Метода запускает таск на выполнение
    void execute();

    // Возвращает результат выполнения
    T getResult();
}
