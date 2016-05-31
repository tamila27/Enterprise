package com.goit.gojavaonline.module1;

/**
 * Created by tamila on 5/30/16.
 */
public class DummyStubObject implements Comparable{

    private int i;

    public DummyStubObject(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DummyStubObject that = (DummyStubObject) o;

        return i == that.i;

    }

    @Override
    public int hashCode() {
        return i;
    }

    @Override
    public int compareTo(Object o) {
        if(this.i < ((DummyStubObject)o).getI()){
            return -1;
        } else if(this.i > ((DummyStubObject)o).getI()){
            return 1;
        }
        return 0;
    }
}
