package com.company;

import com.company.players.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Board {
    private List<Token> tokens;

    public Board(Integer numberOFTokens, Integer maxValue) {
        tokens = new ArrayList<>();
        for (int i = 0; i < numberOFTokens; i++) {
            tokens.add(new Token(maxValue));
        }
    }

    public synchronized Token play(@NotNull Player player) {
        Token pickedToken = null;
        try {
            this.notifyAll();
            this.wait();
            if (tokens.size() == 0) {
                this.notifyAll();
                return null;
            }
            System.out.println("Tura jucatorului " + player.getName());
            printTokens();
            pickedToken =player.pickToken(this);
            System.out.println("Tura jucatorului " + player.getName() + " s-a sfarsit\n");
        } catch (Exception ignored) {
            System.out.println("Crapa ?");
        }
        return pickedToken;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void printTokens() {
        for (int i = 0; i < tokens.size(); ++i) {
            System.out.println(i + 1 + " : " + tokens.get(i));
        }
    }
}
