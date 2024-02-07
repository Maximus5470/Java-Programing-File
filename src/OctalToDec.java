import java.util.Scanner;

public class OctalToDec {
    public static void main(String[] args) {
        hexToDec();
    }

    public static void octalToDec() {
        Scanner sc = new Scanner(System.in);
        int octal = sc.nextInt();
        int dec = 0;
        for (int i = 0; octal > 0; i++) {
            int rem = octal % 10;
            dec += rem * (int) Math.pow(8, i);
            octal /= 10;
        }
        System.out.println(dec);
    }

    public static void hexToDec() {
        Scanner sc = new Scanner(System.in);
        String hex = sc.nextLine();
    }
}
