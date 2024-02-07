package Code365;

import java.util.Scanner;

public class Day7_Valid_IPv6_Address {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String raw = sc.nextLine();
            System.out.println(raw.matches("([a-fA-F0-9]{1,4}:){7}[a-fA-F0-9]{1,4}") ? "valid" : "invalid");
        }
    }
}