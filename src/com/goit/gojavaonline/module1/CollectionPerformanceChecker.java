package com.goit.gojavaonline.module1;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by tamila on 5/28/16.
 */
public abstract class CollectionPerformanceChecker {
    public static void populate(List<Object> list, int n){
        for (int i = 0; i < n; i++) {
            list.add(new DummyStubObject((int)(Math.random()*n)));
        }
    }

    public static void populate(Set<Object> set, int n){
        for (int i = 0; i < n; i++) {
            set.add(new DummyStubObject(i));
        }
    }

    public static long checkPopulateElements(List<Object> list, int n){
        long time = System.nanoTime();
        populate(list, n);
        return System.nanoTime() - time;
    }

    public static long checkPopulateElements(Set<Object> set, int n){
        long time = System.nanoTime();
        populate(set, n);
        return System.nanoTime() - time;
    }

    public static long checkElementsSequentDeletion1(List<Object> list, int n){
        populate(list, n);
        long time = System.nanoTime();
        /*while(!list.isEmpty()){
            list.remove(list.size() - 1);
        }*/
        list.remove(list.size() - 1);
        return System.nanoTime() - time;
    }

    public static long checkElementsSequentDeletion1(Set<Object> set, int n){
        populate(set, n);
        long time = System.nanoTime();
        /*while(!set.isEmpty()){
            set.remove(new DummyStubObject(set.size() - 1));
        }*/
        set.remove(new DummyStubObject(set.size() - 1));
        return System.nanoTime() - time;
    }

    public static long checkElementsSequentDeletion2(List<Object> list, int n){
        populate(list, n);
        long time = System.nanoTime();
        /*while(!list.isEmpty()){
            list.remove(0);
        }*/
        list.remove(0);
        return System.nanoTime() - time;
    }

    public static long checkElementsSequentDeletion2(Set<Object> set, int n){
        populate(set, n);
        long time = System.nanoTime();
        /*int i = 0;
        while(!set.isEmpty()){
            set.remove(new DummyStubObject(i++));
        }*/
        set.remove(new DummyStubObject(0));
        return System.nanoTime() - time;
    }

    public static long checkAddRandomElements(List<Object> list, int n){
        populate(list, n);
        long time = System.nanoTime();
        /*list.add(new DummyStubObject(0));
        while(list.size() < n){
            int index = (int)Math.round(Math.random() * (list.size() - 1));
            list.add(index, new DummyStubObject(index));
        }*/
        int index = (int)Math.round(Math.random() * (list.size() - 1));
        list.add(index, new DummyStubObject(index));
        return System.nanoTime() - time;
    }

    public static long checkAddRandomElements(Set<Object> set, int n){
        populate(set, n);
        long time = System.nanoTime();
        /*set.add(new DummyStubObject(0));
        int i = n;
        while(set.size() < n){
            int index = (int)Math.round(Math.random() * i--);
            set.add(new DummyStubObject(index));
        }*/
        int index = (int)Math.round(Math.random() * n);
        set.add(new DummyStubObject(index));
        return System.nanoTime() - time;
    }

    public static long checkDeleteRandomElements(List<Object> list, int n){
        populate(list, n);
        int index = (int)Math.round(Math.random() * (list.size() - 1));
        long time = System.nanoTime();
        /*while(list.size() > 0){
            int index = (int)Math.round(Math.random() * (list.size() - 1));
            list.remove(index);
        }*/
        list.remove(index);
        return System.nanoTime() - time;
    }

    public static long checkDeleteRandomElements(Set<Object> set, int n){
        populate(set, n);
        DummyStubObject dummyStubObject;
        do{
            int i = (int)Math.round(Math.random() * (set.size() - 1));
            dummyStubObject = new DummyStubObject(i);
        } while(!set.contains(dummyStubObject));
        long time = System.nanoTime();
        set.remove(dummyStubObject);
        return System.nanoTime() - time;
    }

    public static long checkGetRandomElements(List<Object> list, int n){
        populate(list, n);
        long time = System.nanoTime();
        //while(n-- > 0){
            int index = (int)Math.round(Math.random() * (list.size() - 1));
            list.get(index);
        //}
        return System.nanoTime() - time;
    }

    public static long checkIteratorGetElements(List<Object> list, int n){
        populate(list, n);
        long time = System.nanoTime();
        Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        return System.nanoTime() - time;
    }


    public static long checkContainsRandomElements(List<Object> list, int n){
        populate(list, n);
        long time = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            int index = (int)Math.round(Math.random() * (list.size() - 1));
            list.contains(new DummyStubObject(index));
        }
        return System.nanoTime() - time;
    }

    public static long checkContainsRandomElements(Set<Object> set, int n){
        populate(set, n);
        long time = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            int index = (int)Math.round(Math.random() * (set.size() - 1));
            set.contains(new DummyStubObject(index));
        }
        return System.nanoTime() - time;
    }

    public static long checkIteratorAddElements(List<Object> list, int n){
        populate(list, n);
        int index = (int)Math.round(Math.random() * (list.size() - 1));
        Iterator<Object> iterator = list.iterator();
        long time = System.nanoTime();
        while (iterator.hasNext()) {
            DummyStubObject next = (DummyStubObject) iterator.next();
            if(next.getI() == index){
                list.add(new DummyStubObject(index));
                break;
            }
        }
        return System.nanoTime() - time;
    }

    public static long checkIteratorRemoveElements(List<Object> list, int n){
        populate(list, n);
        int index = (int)Math.round(Math.random() * (list.size() - 1));
        Iterator<Object> iterator = list.iterator();
        long time = System.nanoTime();
        while (iterator.hasNext()) {
            DummyStubObject next = (DummyStubObject) iterator.next();
            if(next.getI() == index){
                list.remove(index);
                break;
            }
        }
        return System.nanoTime() - time;
    }
}
