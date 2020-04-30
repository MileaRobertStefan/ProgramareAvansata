package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//Create the class ClientThread. An instance of this class will be responsible with communicating with a client Socket.
// If the server receives the command stop it will stop and will return to the client the respons "Server stopped", otherwise it return: "Server received the request ... ".
public class ClientThread implements Runnable {
    private Socket socket = null;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        CenterOfCommand centerOfCommand = new CenterOfCommand();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream() ) );
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            centerOfCommand.setCommand( in.readLine() );
            String request = centerOfCommand.analiza();


            String raspuns = request;
            out.println(raspuns);
            out.flush();
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
