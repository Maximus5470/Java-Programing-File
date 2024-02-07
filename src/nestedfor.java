import java.util.Scanner;

public class nestedfor {
    public static void main(String[] args) {
        timetable();
    }
    public static void box1() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        for (int i = 1; i <= a; i++) {
            System.out.print("*");
            for (int j = 1; j <= a - 2; j++) {
                System.out.print((i == 1 || i == a) ? "*" : " ");
            }
            System.out.println("*");
        }
    }

    public static void timetable() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        for (int i = 1; i <= a + 1; i++) {
            for (int j = 1; j <= a + 1; j++) {
                if (i == 1) System.out.print(((j - 1) == 0) ? "* " : (j - 1) + " ");
                else if (j != 1) System.out.print((j - 1) * (i - 1) + " ");
                else System.out.print(j * (i - 1) + " ");
            }
            System.out.println();
        }
    }

    public static void uprightTriangle(int size) {
        int max_width = (2 * size) + 1, offset = max_width / 2, width = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < max_width; j++) {
                if (j < offset) System.out.print("  ");
                else if (j < width + offset) System.out.print("# ");
            }
            width += 2;
            offset--;
            System.out.println();
        }
    }

    public static void upsideDownTriangle(int size) {
        int max_width = (2 * size) + 1, offset = 1, width = max_width - 2;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < max_width; j++) {
                if (j < offset) System.out.print("  ");
                else if (j < width + offset) System.out.print("# ");
            }
            width -= 2;
            offset++;
            System.out.println();
        }
    }

    public static void rhombus(int size) {
        int max_width = (2 * size) + 1, offset = max_width / 2, width = 1;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < max_width; j++) {
                if (j < offset) System.out.print("  ");
                else if (j < width + offset) System.out.print("# ");
            }
            width += 2;
            offset--;
            System.out.println();
        }
        int offset2 = 1, width2 = max_width - 2;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < max_width; j++) {
                if (j < offset2) System.out.print("  ");
                else if (j < width2 + offset2) System.out.print("# ");
            }
            width2 -= 2;
            offset2++;
            System.out.println();
        }
    }

    public static void hollowRhombus(int size) {
        int max_width = (2 * size) + 1, offset = max_width / 2, width = 1;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < max_width; j++) {
                if (j < offset || j >= width + offset) System.out.print("# ");
                else if (j < width + offset) System.out.print("  ");
            }
            width += 2;
            offset--;
            System.out.println();
        }
        int offset2 = 1, width2 = max_width - 2;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < max_width; j++) {
                if (j < offset2 || j >= width2 + offset2) System.out.print("# ");
                else if (j < width2 + offset2) System.out.print("  ");
            }
            width2 -= 2;
            offset2++;
            System.out.println();
        }
    }
}
