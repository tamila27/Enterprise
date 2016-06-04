package com.goit.gojavaonline.module2;

/**
 * Created by tamila on 6/2/16.
 */
public interface Validator<E> {
    // Валидирует переданое значение
    boolean isValid(E result);
}
