package client;

import server.GameSessionServer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CenterOfCommand {

    public static final String createGame = "create game";
    public static final String joinGame = "join game";
    public static final String submitMove = "submit move";
    public static final String exit = "exit";
    public static final String a = "";

    private static List<String> commandList;

    private String command;

    public void setCommand(String command) {
        this.command = command;
    }

    private String parseCommand() {
        for (String prefix : commandList) {
            if (command.startsWith(prefix))
                return prefix;
        }
        return "";
    }

    public String analiza() throws IOException {
        String comanda = parseCommand();
        String rez = "";
        switch (comanda) {
            case createGame: {
                rez = "" + (GameSessionServer.PORT + 1);
                new Thread(new GameSessionServer()).start();
            }
            break;
            case joinGame: {
                rez = "" + GameSessionServer.PORT;
            }
            break;
            case submitMove: {
                rez = submitMove;
            }
            break;
            case exit: {
                System.exit(0);
            }
            break;
        }
        return rez;
    }


    public CenterOfCommand() {
        commandList = new ArrayList<>();

        commandList.add(createGame);
        commandList.add(joinGame);
        commandList.add(submitMove);
        commandList.add(exit);

    }
}
