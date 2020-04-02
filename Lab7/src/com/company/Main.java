package com.company;

import com.company.players.Player;

public class Main {

    public static void main(String[] args) {
        Player.turnNumber = 0;
        new Game().main();
    }
}
