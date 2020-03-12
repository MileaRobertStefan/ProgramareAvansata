package com.company.compulsory;

public class Hospital implements  Comparable<Hospital> {

    private String name;
    private int capacity;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Hospital(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Hospital o) {
        return  this.name.compareTo(o.getName()) ;
    }

    @Override
    public String toString() {
        return "{" +
                 name +
                " , " + capacity +
                '}';
    }
}
