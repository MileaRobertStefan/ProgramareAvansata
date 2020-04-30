package server;

import client.PlayerThread;
import client.game.Gomoku;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameSessionServer implements  Runnable {
    public static int PORT = 3001;

    public GameSessionServer()  {

    }

    public static void incrementPort() {
        PORT++;
    }

    @Override
    public void run() {
        ServerSocket serverSocket = null;
        Gomoku gomoku = new Gomoku();
        try {
            incrementPort();
            serverSocket = new ServerSocket(PORT);
            while (!gomoku.gameDone()) {
                System.out.println(PORT);
                Socket socket = serverSocket.accept();
                new Thread(new PlayerThread(socket,gomoku)).start();
            }

        } catch (IOException e) {
            System.err.println("Ooops... " + e);


        } finally {
            assert serverSocket != null;
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
