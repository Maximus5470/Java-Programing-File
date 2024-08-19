import java.util.Random;
import java.util.Scanner;

public class Minesweeper {
    static String[][] Board;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the board: ");
        int size = sc.nextInt();
        System.out.print("Enter the number of mines: ");
        int mines = sc.nextInt();
        Board = new String[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Board[i][j] = " ";
            }
        }
        Random rand = new Random();
        for (int i = 0; i < mines; i++) {
            int x = rand.nextInt(size);
            int y = rand.nextInt(size);
            Board[x][y] = "B";
        }
    }
}
