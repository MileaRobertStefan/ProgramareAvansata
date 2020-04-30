package server;

import client.ClientThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//Create the class GameServer. An instance of this class will create a ServerSocket running at a specified port.
//The server will receive requests (commands) from clients and it will execute them.
public class GameServer {
    public static final int PORT = 3000;

    public GameServer() throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                System.out.println("Waiting for a client on " + PORT);
                Socket socket = serverSocket.accept();
                new Thread(new ClientThread(socket)).start();
            }
        } catch (IOException e) {
            System.err.println("Ooops... " + e);
        } finally {
            assert serverSocket != null;
            serverSocket.close();
        }
    }


}
