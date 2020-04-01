package com.company;

import com.company.players.ManualPlayer;
import com.company.players.Player;
import com.company.players.RandomPlayer;
import com.company.players.SmartPlayer;

public class Game {
    public void main() {
        Board board = new Board(1000, 1200);
        Player ion = new SmartPlayer("Ion",board);
        Player vasile = new SmartPlayer("Vasile",board);

        new Thread(ion).start();
        new Thread(vasile).start();
    }

}
