package com.company.players;

import com.company.Board;
import com.company.Token;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class SmartPlayer extends Player {
    Map<Token, List<Token>> bestOutput;
    List<Token> listOfAllTokens;
    public SmartPlayer(String name, Board board) {
        super(name, board);
        bestOutput = new HashMap<>();
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
        bestOutput.clear();
        List<Token> tokens = board.getTokens();
        tokens.sort(new Comparator<Token>() {
            @Override
            public int compare(Token o1, Token o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        Token token = new Token(1);
        int maxLenght = 2;
        for (int i = 0; i < tokens.size() - 1; i++) {
            List<Token> progresie = new ArrayList<>();
            List<Token> auxiliary = new ArrayList<>();
            int localMaxLenght = 0;
            for (int j = i + 1; j < tokens.size(); j++) {
                final int dif = tokens.get(j).getValue() - tokens.get(i).getValue();
                if (dif != 0) {
                    token.setValue(tokens.get(j).getValue() + dif);
                    int lenght = 2;
                    auxiliary.clear();
                    auxiliary.add(tokens.get(j));
                    while (tokens.contains(token) ){
                        auxiliary.add(tokens.get(tokens.indexOf(token)));
                        lenght++;
                        token.setValue(token.getValue() + dif);
                    }
                    if (lenght > maxLenght) {
                        maxLenght = lenght;
                    }
                    if (lenght > localMaxLenght) {
                        localMaxLenght = lenght;
                        progresie.clear();
                        progresie.addAll(auxiliary);
                    }
                }
            }
            bestOutput.put(tokens.get(i), progresie);
        }
        maxLenght = -1;
        for( var entry : bestOutput.entrySet()){
            if(entry.getValue().size() > maxLenght){
                maxLenght = entry.getValue().size();
                token = entry.getKey();
            }
        }

        return  maxLenght == -1 ? tokens.get(0) : token;
    }

    public Token pickToken(@NotNull Board board) {
        if (board.getTokens().size() ==0)
        {
            return  null;
        }
        Token token = analyzes();
        board.getTokens().remove(token);
        return  token;
    }
}
