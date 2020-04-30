package client.game;

public class Gomoku {
    private static final int W = 15;
    private static final int H = 15;

    private int[][] board;
    int player = 1;

    public Gomoku() {
        board = new int[W][H];
    }

    public int getPlayer() {
        return player;
    }

    public boolean setPiece(int x, int y) {
        if (!((1 <= x && x <= W) && (1 <= y && y <= H))) //daca nu e pe tabala
            return false;
        if (board[x - 1][y - 1] != 0) return false; //daca nu e libera
        board[x - 1][y - 1] = player;
        player = 3 - player; // .. - >  1 -> 2 -> 1 -> ..
        return true;
    }

    public boolean gameDone() { //4 N^2 meh
        // check |
        boolean endGame = false;
        for (int i = 0; i <= W - 5; i++)
            for (int j = 0; j < H; j++) {
                if (board[i][j] != 0) { // nu verificam pentru spatii goale
                    endGame = true;
                    for (int k = 1; k < 5; k++) {
                        if (board[i][j] != board[i + k][j]) {
                            endGame = false;
                            break;
                        }
                    }
                    if (endGame) return true;
                }
            }
        // check -
        for (int i = 0; i < W; i++)
            for (int j = 0; j <= H - 5; j++) {
                if (board[i][j] != 0) { // nu verificam pentru spatii goale
                    endGame = true;
                    for (int k = 1; k < 5; k++) {
                        if (board[i][j] != board[i][j + k]) {
                            endGame = false;
                            break;
                        }
                    }
                    if (endGame) return true;
                }
            }

        //chack \
        for (int i = 0; i <= W - 5; i++) {
            for (int j = 0; j <= H - 5; j++) {
                if (board[i][j] != 0) { // nu verificam pentru spatii goale
                    endGame = true;
                    for (int k = 1; k < 5; k++) {
                        if (board[i][j] != board[i + k][j + k]) {
                            endGame = false;
                            break;
                        }
                    }
                    if (endGame) return true;
                }
            }
        }
        //chack /
        for (int i = 4; i < W; i++) {
            for (int j = 0; j <= H - 5; j++) {
                if (board[i][j] != 0) { // nu verificam pentru spatii goale
                    endGame = true;
                    for (int k = 1; k < 5; k++) {
                        if (board[i][j] != board[i - k][j + k]) {
                            endGame = false;
                            break;
                        }
                    }
                    if (endGame) return true;
                }
            }
        }
        return false;
    }

    public String print() {
        StringBuilder tabla = new StringBuilder();
        for (int[] ints : board) {
            for (int anInt : ints) {
                tabla.append(anInt).append(" ");
            }
            tabla.append("\n");
        }
        return  tabla.toString();
    }
}
