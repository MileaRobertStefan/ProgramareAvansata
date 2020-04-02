package com.company;

import com.company.players.ManualPlayer;
import com.company.players.Player;
import com.company.players.RandomPlayer;
import com.company.players.SmartPlayer;

public class Game {
    public void main() {
        Board board = new Board(12*100, 12*110,6);
        new Thread(new Daemon(10)).start();
        new Thread(new SmartPlayer("SmartGigi",board)).start();
        new Thread(new SmartPlayer("SmartIon",board)).start();
        new Thread(new SmartPlayer("SmartGheorghe",board)).start();

        new Thread(new RandomPlayer("RandomCostache",board)).start();
        new Thread(new RandomPlayer("RandomVasile",board)).start();
        new Thread(new RandomPlayer("RandomMaria",board)).start();
    }

}
