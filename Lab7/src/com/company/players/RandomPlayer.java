package com.company.players;

import com.company.Board;
import com.company.Token;

import java.util.Random;

public class RandomPlayer extends Player {

    public RandomPlayer(String name, Board board) {
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

    @Override
    public Token pickToken(Board board) {
        if (board.getTokens().size() == 0) {
            return null;
        }
        int index = new Random().nextInt(board.getTokens().size());
        Token token = board.getTokens().get(index);
        board.getTokens().remove(token);
        System.out.println(name + " a ales " + token.getValue());
        return token;
    }
}