import java.util.*;

public class Master {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int gap = 2 * size - 2;
        for (int i = 1; i <= size; i++) {
            for (int j = 0; j < 2 * size; j++) {
                if (j < i) System.out.print("* ");
                else if (j < i + gap) System.out.print("  ");
                else System.out.print("* ");
            }
            gap -= 2;
            System.out.println();
        }
        gap+=2;
        for (int i = size; i >= 1; i--) {
            for (int j = 0; j < 2 * size; j++) {
                if (j < i) System.out.print("* ");
                else if (j < i + gap) System.out.print("  ");
                else if(j>i+gap-2) System.out.print("* ");
            }
            gap += 2;
            System.out.println();
        }
    }
}