package com.company.players;

import com.company.Board;
import com.company.Token;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class ManualPlayer extends Player {

    @Override
    public void run() {
        do {
            chosenTokens.add(board.play(this));
        } while (chosenTokens.get(chosenTokens.size() - 1) != null);
        chosenTokens.remove(null);
        endMsg();
    }

    public ManualPlayer(String name, Board board) {
        super(name, board);
    }

    @Override
    public Token pickToken(@NotNull Board board) {
        Scanner reader = new Scanner(System.in);
        int index;
        do {
            System.out.println("Alege un numar :");
            index = reader.nextInt();
        } while (!(0 < index && index <= board.getTokens().size()));
        Token token = board.getTokens().get(index - 1);
        board.getTokens().remove(token);
        return token;
    }
}
