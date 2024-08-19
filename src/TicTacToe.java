import java.util.Objects;
import java.util.Scanner;

class Player {
    private final String choice;
    private final String name;

    public Player(String choice, String name) {
        this.choice = choice;
        this.name = name;
    }

    public void play() {
        Scanner sc = new Scanner(System.in);
        System.out.print(name + ": ");
        String[] v1 = sc.nextLine().split(",");
        int p1_coord1 = Integer.parseInt(v1[0]);
        int p1_coord2 = Integer.parseInt(v1[1]);

        while (!TicTacToe.checkEntry(p1_coord1, p1_coord2)) {
            System.out.println("Invalid entry");
            System.out.print(name + ": ");
            v1 = sc.nextLine().split(",");
            p1_coord1 = Integer.parseInt(v1[0]);
            p1_coord2 = Integer.parseInt(v1[1]);
        }
        TicTacToe.board[p1_coord1][p1_coord2] = choice;
        TicTacToe.show();
    }
}

public class TicTacToe {
    static String[][] board = new String[3][3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Player 1 choice (O/X): ");
        String p1_choice = sc.nextLine();
        String p2_choice = Objects.equals(p1_choice, "O") ? "X" : "O";
        Player player1 = new Player(p1_choice, "Player 1");
        Player player2 = new Player(p2_choice, "Player 2");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = " ";
            }
        }

        if (p1_choice.equals("X")) {
            int i;
            for (i = 0; i < 4; i++) {
                player1.play();
                if (checkWin()) {
                    System.out.println("Player 1 wins");
                    break;
                }
                player2.play();
                if (checkWin()) {
                    System.out.println("Player 2 wins");
                    break;
                }
            }
            if (i == 3) {
                player1.play();
                if (checkWin()) {
                    System.out.println("Player 1 wins");
                } else {
                    System.out.println("It's a Draw");
                }
            }
        } else {
            int i;
            for (i = 0; i < 4; i++) {
                player2.play();
                if (checkWin()) {
                    System.out.println("Player 2 wins");
                    break;
                }
                player1.play();
                if (checkWin()) {
                    System.out.println("Player 1 wins");
                    break;
                }
            }
            if (i == 3) {
                player2.play();
                if (checkWin()) {
                    System.out.println("Player 2 wins");
                } else {
                    System.out.println("It's a Draw");
                }
            }
        }
    }

    public static void show() {
        for (int i = 0; i < 3; i++) {
            System.out.println(board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) {
                System.out.println("---------");
            }
        }
    }

    public static boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(board[i][0], board[i][1]) && Objects.equals(board[i][1], board[i][2]) && !Objects.equals(board[i][0], " ")) {
                return true;
            }
            if (Objects.equals(board[0][i], board[1][i]) && Objects.equals(board[1][i], board[2][i]) && !Objects.equals(board[0][i], " ")) {
                return true;
            }
        }
        if (Objects.equals(board[0][0], board[1][1]) && Objects.equals(board[1][1], board[2][2]) && !Objects.equals(board[0][0], " ")) {
            return true;
        }
        return Objects.equals(board[0][2], board[1][1]) && Objects.equals(board[1][1], board[2][0]) && !Objects.equals(board[0][2], " ");
    }

    public static boolean checkEntry(int x, int y) {
        if (x < 0 || x > 2 || y < 0 || y > 2) {
            return false;
        }
        return Objects.equals(board[x][y], " ");
    }
}