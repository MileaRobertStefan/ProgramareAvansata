package client;

import client.game.Gomoku;
import client.game.Logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class PlayerThread implements Runnable {
    private Socket socket = null;
    private Gomoku gomoku;

    public PlayerThread(Socket socket, Gomoku gomoku) {
        this.socket = socket;
        this.gomoku = gomoku;
    }

    public void run() {
        Logic game = new Logic(gomoku);
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (!gomoku.gameDone()) {
                String r = game.commandManager(in);
                System.out.println(r);
                out.println(r);
                out.flush();
            }

        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}
