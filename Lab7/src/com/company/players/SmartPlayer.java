package com.company.players;

import com.company.Board;
import com.company.Token;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class SmartPlayer extends Player {


    public SmartPlayer(String name, Board board) {
        super(name, board);

    }

    @Override
    public void run() {
        do {
            chosenTokens.add(board.play(this));
        } while (chosenTokens.get(chosenTokens.size() - 1) != null);
        chosenTokens.remove(null);
        endMsg();
    }

    // complexitate N^3 ..mna ..aia e i7 si gtx1080 cereinte minime
    private Token analyzes() {
        Map<Token, Integer> values = new HashMap<>() ;
        Map<Token, Integer> myValues = new HashMap<>() ;
        for (Token tk : board.getTokens()) {
            values.put(tk, 0);
        }
        for (Token tk : chosenTokens) {
            myValues.put(tk, 0);
        }
        int tokenLenght = 0;
        int maxDif = 0;
        Token decoy = new Token(1);
        for (int i = 0; i < board.getTokens().size() - 1; i++) {
            tokenLenght = 0;
            maxDif = 0;
            for (int j = i + 1; j < board.getTokens().size(); j++) {
                int dif = board.getTokens().get(j).getValue() - board.getTokens().get(i).getValue();
                if (dif != 0) {
                    decoy.setValue(board.getTokens().get(j).getValue());
                    int lenght = 1;
                    while (values.containsKey(decoy) || myValues.containsKey(decoy) ) {
                        decoy.setValue(decoy.getValue() + dif);
                        lenght++;
                    }

                    if (tokenLenght < lenght) {
                        tokenLenght = lenght;
                    }
                }
            }
            values.put(board.getTokens().get(i), tokenLenght);
        }
        tokenLenght = 0;
        for( var et : values.entrySet()){
            if(tokenLenght <= et.getValue()){
                tokenLenght = et.getValue();
                decoy = et.getKey();
            }
        }
        return decoy;
    }

    public Token pickToken(@NotNull Board board) {
        if (board.getTokens().size() == 0) {
            return null;
        }
        Token token = analyzes();
        board.getTokens().remove(token);
        System.out.println(name + " a ales " + token.getValue());
        return token;
    }
}