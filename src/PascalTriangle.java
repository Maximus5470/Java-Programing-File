import java.util.ArrayList;
import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        int a=new Scanner(System.in).nextInt();
        for (int i = 0; i < a; i++) {
            System.out.println(getRow(i));
        }
    }
    public static ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        long prev = 1;
        for (int r = 1; r <= rowIndex; r++) {
            long next = prev * (rowIndex - r + 1) / r;
            res.add((int) next);
            prev = next;
        }
        return res;
    }
}