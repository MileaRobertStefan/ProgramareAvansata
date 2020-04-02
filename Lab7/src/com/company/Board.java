package com.company;

import com.company.players.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Board {
    public static int stop;
    private int turn;
    private int nrOfPlayers;
    private List<Token> tokens;

    public Board(Integer numberOFTokens, Integer maxValue, Integer nrOfPlayers) {
        tokens = new ArrayList<>();
        stop = 0;
        this.nrOfPlayers = nrOfPlayers;
        for (int i = 0; i < numberOFTokens; i++) {
            Token token = new Token(maxValue);
            while (tokens.contains(token)) {
                token = new Token(maxValue);
            }
            tokens.add(token);
        }
        tokens.sort(new Comparator<Token>() {
            @Override
            public int compare(Token o1, Token o2) {
                return o1.getValue() - o2.getValue();
            }
        });
    }

    private int getTurn() {
        return turn;
    }

    private synchronized void setTurn() {
        this.turn = (this.turn + 1) % nrOfPlayers;
    }

    public synchronized Token play(@NotNull Player player) {
        Token pickedToken = null;
        try {
            this.notify();
            while (player.getMyTurn() != turn) {
                this.wait(10);
            }
            if (tokens.size() == 0 || stop == 1) {
                this.notifyAll();
                setTurn();
                return null;
            }
            System.out.println("Tura jucatorului " + player.getName());
            printTokens();
            pickedToken = player.pickToken(this);
            System.out.println("Tura jucatorului " + player.getName() + " s-a sfarsit\n");
            setTurn();
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
