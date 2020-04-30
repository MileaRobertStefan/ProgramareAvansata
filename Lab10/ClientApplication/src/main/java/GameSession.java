import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GameSession {


    private static final Scanner in = new Scanner(System.in);

    private String inputCommand() {
        return in.nextLine();
    }

    private void actionPrint(String request, PrintWriter out, BufferedReader inServer) throws IOException {
        out.println(ConstStrings.print);
        out.flush();
        for (int i = 0; i < 16; i++) {
            String response = inServer.readLine();
            System.out.println(response);
        }
    }

    private void actionSubmitMove(String request, PrintWriter out, BufferedReader inServer) throws IOException {
        String[] strings;
        String response = "fail";
        while (response.equals("fail")) {

            try {
                out.println(ConstStrings.submitMove + " " + in.nextInt() + " " +  in.nextInt() );
                out.flush();
                response = inServer.readLine();
            } catch (Exception ignored) {}
        }
        System.out.println("Move successful !");
        actionPrint(request, out, inServer);
    }

    private void actionExit(String request, PrintWriter out, BufferedReader inServer) {
        out.println(ConstStrings.exit);
        out.flush();
        System.exit(0);
    }

    public String commandManager(String request, PrintWriter out, BufferedReader inServer) throws IOException {

        if (request.startsWith(ConstStrings.print)) {
            actionPrint(request, out, inServer);
        }

        if (request.startsWith(ConstStrings.submitMove)) {
            actionSubmitMove(request, out, inServer);
        }

        if (request.startsWith(ConstStrings.exit)) {
            actionExit(request, out, inServer);
        }
        return null;
    }


    public void createGame(int PORT, String serverAddress) throws IOException {
        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader inServer = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            System.out.println(" Connected to the game " + PORT);

            String gameStatus = "false";

            while (gameStatus.equals("false")) {
                commandManager(inputCommand(), out, inServer);

                out.println("gameStatus");
                out.flush();
                gameStatus = inServer.readLine();
            }


        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }

    }


}
