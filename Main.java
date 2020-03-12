package com.company;

import com.company.compulsory.Compulsory;

public class Main {

    public static void main(String[] args) {
        Compulsory compulsory = new Compulsory();
        compulsory.main(args);

        Problem problem = new Problem();
        problem.init(4, 3);
        problem.print();
        Matching matching = new Matching(problem);
        matching.solve();
    }
}
