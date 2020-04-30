import server.GameServer;

import java.io.IOException;

public class Main {


    /*
The server is responsible with the game management and mediating the players.
The client will communicate with the server, sending it commands such as:
create or join a game,
submit a move, etc.
The main specifications of the application are:

Compulsory (1p)

Create the project ServerApplication. This will contain (at least) the classes: GameServer and ClientThread.
Create the class GameServer. An instance of this class will create a ServerSocket running at a specified port.
 The server will receive requests (commands) from clients and it will execute them.
Create the class ClientThread. An instance of this class will be responsible with communicating with a client Socket.
 If the server receives the command stop it will stop and will return to the client the respons "Server stopped", otherwise it return: "Server received the request ... ".
Create the project ClientApplication. This will contain (at least) the class: GameClient.
Create the class GameClient. An instance of this class will read commands from the keyboard and it will send them to the server.
The client stops when it reads from the keyboard the string "exit".
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Merge");

        try {
            GameServer server = new GameServer ();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
