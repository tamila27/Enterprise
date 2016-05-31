package com.goit.gojavaonline.module1;

import java.util.*;
import java.util.function.BiFunction;

/**
 * Created by tamila on 5/31/16.
 */
public class ExperimentManager {
    private static final int EXPERIMENTS_COUNT = 100;
    private static final String[] TABLE_HEADER = new String[]{" ", "add", "get", "remove(last)", "remove(first)", "remove(random)", "contains", "populate", "Iterator.get", "Iterator.add", "Iterator.remove"};
    private static final String FORMAT_STRING = "| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |\n";

    public static String startTest( int collectionLength){
        StringBuilder result = new StringBuilder(String.format(FORMAT_STRING, TABLE_HEADER));
        result.append( runExperimentForList(LinkedList.class, collectionLength));
        result.append( runExperimentForList(ArrayList.class, collectionLength));
        result.append( runExperimentForSet(HashSet.class, collectionLength));
        result.append( runExperimentForSet(TreeSet.class, collectionLength));
        return result.toString();
    }
    public static String runExperimentForList(Class<? extends List> listClass, int listLength) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(FORMAT_STRING, listClass.getSimpleName(),
                runTestForList(listClass, listLength, CollectionPerformanceChecker::checkAddRandomElements),
                runTestForList(listClass, listLength, CollectionPerformanceChecker::checkGetRandomElements),
                runTestForList(listClass, listLength, CollectionPerformanceChecker::checkElementsSequentDeletion1),
                runTestForList(listClass, listLength, CollectionPerformanceChecker::checkElementsSequentDeletion2),
                runTestForList(listClass, listLength, CollectionPerformanceChecker::checkDeleteRandomElements),
                runTestForList(listClass, listLength, CollectionPerformanceChecker::checkContainsRandomElements),
                runTestForList(listClass, listLength, CollectionPerformanceChecker::checkPopulateElements),
                runTestForList(listClass, listLength, CollectionPerformanceChecker::checkIteratorGetElements),
                runTestForList(listClass, listLength, CollectionPerformanceChecker::checkIteratorAddElements),
                runTestForList(listClass, listLength, CollectionPerformanceChecker::checkIteratorRemoveElements)));
        return stringBuilder.toString();
    }

    public static String runExperimentForSet(Class<? extends Set> setClass, int setLength) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(FORMAT_STRING, setClass.getSimpleName(),
                runTestForSet(setClass, setLength, CollectionPerformanceChecker::checkAddRandomElements),
                " ",
                runTestForSet(setClass, setLength, CollectionPerformanceChecker::checkElementsSequentDeletion1),
                runTestForSet(setClass, setLength, CollectionPerformanceChecker::checkElementsSequentDeletion2),
                runTestForSet(setClass, setLength, CollectionPerformanceChecker::checkDeleteRandomElements),
                runTestForSet(setClass, setLength, CollectionPerformanceChecker::checkContainsRandomElements),
                runTestForSet(setClass, setLength, CollectionPerformanceChecker::checkPopulateElements),
                " ",
                " ",
                " "));
        return stringBuilder.toString();
    }

    private static long runTestForList(Class<? extends List> listClass,
                                       int listLength, BiFunction<List<Object>, Integer, Long> testMethod) {
        long experimentsTotalTime = 0;
        for (int i = 0; i < EXPERIMENTS_COUNT; i++) {
            List<Object> list = newList(listClass);
            experimentsTotalTime += testMethod.apply(list, listLength);
        }
        return experimentsTotalTime/EXPERIMENTS_COUNT;
    }

    private static long runTestForSet(Class<? extends Set> setClass,
                                      int setLength, BiFunction<Set<Object>, Integer, Long> testMethod) {
        long experimentsTotalTime = 0;
        for (int i = 0; i < EXPERIMENTS_COUNT; i++) {
            Set<Object> list = newSet(setClass);
            experimentsTotalTime += testMethod.apply(list, setLength);
        }
        return experimentsTotalTime/EXPERIMENTS_COUNT;
    }

    @SuppressWarnings("unchecked")
    private static List<Object> newList(Class<? extends List> listClass) {
        try {
            return (List<Object>) listClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            System.err.println("Failed to new collection from class instance. Error: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    private static Set<Object> newSet(Class<? extends Set> setClass) {
        try {
            return (Set<Object>) setClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            System.err.println("Failed to new collection from class instance. Error: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
