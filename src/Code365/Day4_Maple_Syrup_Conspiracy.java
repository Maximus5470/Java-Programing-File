package Code365;

import java.util.Scanner;

public class Day4_Maple_Syrup_Conspiracy {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int times=sc.nextInt();
        for (int i = 0; i < times; i++) {
            int size=sc.nextInt();
            int[] b=new int[size];
            for (int j = 0; j < size; j++) {
                b[i]=sc.nextInt();
            }
            for (int j = 0; j < size; j++) {
                if(i%2==0) System.out.print(b[i/2]+" ");
                else System.out.print(b[size-(i+1)/2]);
            }
            System.out.println();
        }
    }
}
