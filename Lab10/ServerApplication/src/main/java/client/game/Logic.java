package client.game;

import java.io.BufferedReader;
import java.io.IOException;

public class Logic {

    private Gomoku gomoku;

    public Logic(Gomoku gomoku) {
        this.gomoku = gomoku;
    }

    public String printGame() {
        return gomoku.print();
    }

    public String move(String request) {
        String[] strings = request.split(" ");
        if (strings.length != 3) {
            return "fail";
        }
        int x = Integer.parseInt(strings[1]);
        int y = Integer.parseInt(strings[2]);
        return (gomoku.setPiece(x, y)) ? "success" : "fail";
    }

    public String commandManager(BufferedReader in) throws IOException {
        String request = in.readLine();

        if (request.startsWith("print")) {
            return printGame();
        }

        if (request.startsWith("move")) {
            return move(request);
        }

        if (request.startsWith("gameStatus")) {
            return gomoku.gameDone() ? "true" : "false";
        }

        if( request.startsWith("exit")) {
            System.exit(0);
        }
        return "nimic";
    }
}
