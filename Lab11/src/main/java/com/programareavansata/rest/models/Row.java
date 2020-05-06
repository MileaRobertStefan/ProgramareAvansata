package com.programareavansata.rest.models;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.ArrayList;
import java.util.List;

@Embeddable
public class Row {
    @ElementCollection

    List<Integer> line;

    public List<Integer> getLine() {
        return line;
    }

    public void setLine(List<Integer> line) {
        this.line = line;
    }

    public Row() {
        line = new ArrayList<>();
        for(int i=0;i<15;i++){
            line.add(0);
        }
    }
}
