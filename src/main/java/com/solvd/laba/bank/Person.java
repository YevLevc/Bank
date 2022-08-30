package com.solvd.laba.bank;

public abstract class Person {
    private int ID;
    private String fullName;

    public Person() {
    }

    public Person(int ID, String fullName) {
        this.ID = ID;
        this.fullName = fullName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return ID +
                ", " + fullName;
    }
}
