package com.company.compulsory;

import java.util.List;
import java.util.Queue;

public class Resident {

    private String name;
    private String familyName;

    public Resident(String name, String familyName) {
        this.name = name;
        this.familyName = familyName;
    }

    public String getName() {
        return name;
    }

    public String getFamilyName() {
        return familyName;
    }

    @Override
    public String toString() {
        return name + " " + familyName + " ";
    }
}
