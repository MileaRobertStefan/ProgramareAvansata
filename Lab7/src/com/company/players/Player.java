package com.company.players;

import com.company.Board;
import com.company.Token;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class Player implements Runnable {
    public static  int turnNumber ;
    protected int  myTurn ;
    protected String name;
    protected Board board;
    protected List<Token> chosenTokens;

    public Player(String name, Board board) {
        this.name = name;
        this.board = board;
        chosenTokens = new ArrayList<>();
        myTurn = turnNumber;
        turnNumber++;
    }

    public int getMyTurn() {
        return myTurn;
    }

    public int calculateLargestArithmeticProgression() {
       // chosenTokens.sort(new Comparator<Token>() {
         //   @Override
         //   public int compare(Token o1, Token o2) {
         //       return o1.getValue() - o2.getValue();
        //    }
     //   });
        System.out.println(name +" "+chosenTokens);
        List<Token> list = new ArrayList<>();
//brute force ca Bute in ring
        int lenghtMax = 2;
        Token token = new Token(1);
        for (int i = 0; i < chosenTokens.size() - 1; i++) {
            for (int j = i + 1; j < chosenTokens.size(); j++) {
                final int dif = chosenTokens.get(j).getValue() - chosenTokens.get(i).getValue();
                if (dif != 0) {
                    int lenght = 2;
                    token.setValue(chosenTokens.get(j).getValue() + dif);
                    List<Token> local = new ArrayList<>();
                    local.add(chosenTokens.get(i));
                    local.add(chosenTokens.get(j));
                    while (chosenTokens.contains(token)) {
                        lenght++;
                        local.add(chosenTokens.get(chosenTokens.indexOf(token)));
                        token.setValue(token.getValue() + dif);
                    }
                    if (lenght > lenghtMax) {
                        lenghtMax = lenght;
                        list.clear();
                        list.addAll(local);
                    }
                }
            }
        }
        System.out.println(list);
        return lenghtMax;
    }


    public String getName() {
        return name;
    }

    public Token pickToken(Board board){return null;}
    protected synchronized void endMsg(){
        System.out.println("Punctaj " + name + " " + calculateLargestArithmeticProgression() + " din  " + chosenTokens.size() + " de piese");
    }
}