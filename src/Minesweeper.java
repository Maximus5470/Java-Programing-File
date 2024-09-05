import java.util.Random;
import java.util.Scanner;

public class Minesweeper {
    static String[][] BoardHidden;
    static String[][] BoardVisible;
    static int flag_count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = 5;
        int mines = size-1;
        BoardHidden = new String[size][size];
        BoardVisible = new String[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                BoardHidden[i][j] = " ";
                BoardVisible[i][j] = "□";
            }
        }
        Random rand = new Random();
        for (int i = 0; i < mines; i++) {
            int x = rand.nextInt(size);
            int y = rand.nextInt(size);
            BoardHidden[x][y] = "B";
        }
        System.out.println("Game Started\n");
        printBoardVisible();
        while (true) {
            System.out.print("Enter your move (x y): ");
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.print("Enter your move (F/S): ");
            String move = sc.next();
            if (move.equals("F")) {
                flag(x, y);
            } else if (move.equals("S")) {
                if (BoardHidden[x][y].equals("B")) {
                    System.out.println("Game Over");
                    break;
                } else {
                    countSurroundingBombs(x, y);
                }
            }
            printBoardVisible();
            if (flag_count == mines) {
                System.out.println("You Win");
                break;
            }
        }
    }

    public static void printBoardHidden() {
        for (String[] strings : BoardHidden) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    public static void printBoardVisible() {
        for (String[] strings : BoardVisible) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    public static void flag(int x, int y) {
        if (BoardVisible[x][y].equals("*")) {
            BoardVisible[x][y] = "F";
            flag_count++;
        } else if (BoardVisible[x][y].equals("F")) {
            BoardVisible[x][y] = "*";
            flag_count--;
        }
    }
    public static void countSurroundingBombs(int x, int y) {
        int count = 0;
        if (x > 0 && y > 0 && BoardHidden[x - 1][y - 1].equals("B")) {
            count++;
        }
        if (x > 0 && BoardHidden[x - 1][y].equals("B")) {
            count++;
        }
        if (x > 0 && y < BoardHidden.length - 1 && BoardHidden[x - 1][y + 1].equals("B")) {
            count++;
        }
        if (y > 0 && BoardHidden[x][y - 1].equals("B")) {
            count++;
        }
        if (y < BoardHidden.length - 1 && BoardHidden[x][y + 1].equals("B")) {
            count++;
        }
        if (x < BoardHidden.length - 1 && y > 0 && BoardHidden[x + 1][y - 1].equals("B")) {
            count++;
        }
        if (x < BoardHidden.length - 1 && BoardHidden[x + 1][y].equals("B")) {
            count++;
        }
        if (x < BoardHidden.length - 1 && y < BoardHidden.length - 1 && BoardHidden[x + 1][y + 1].equals("B")) {
            count++;
        }
        BoardVisible[x][y] = String.valueOf(count);
    }
}
