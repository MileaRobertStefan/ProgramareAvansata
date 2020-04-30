import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GameClient {


    public void connect(String[] args) throws IOException {
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 3000; // The server's port
        GameSession game = new GameSession();
        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            final Scanner tastatura = new Scanner(System.in);
            while (true) {
                switch (tastatura.nextLine()) {
                    case ConstStrings.createGame:
                        out.println(ConstStrings.createGame);
                        game.createGame(Integer.parseInt(in.readLine()), serverAddress);
                        break;
                    case ConstStrings.joinGame:
                        out.println(ConstStrings.joinGame);
                        System.out.println("alege un numar intre 3001 si" + Integer.parseInt(in.readLine()));
                        game.createGame(tastatura.nextInt(), serverAddress);
                        break;
                    case ConstStrings.exit:
                        out.println(ConstStrings.exit);
                        out.flush();
                        System.exit(0);
                        break;
                }

            }
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }

}
