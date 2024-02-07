import java.util.Arrays;
import java.util.Scanner;

public class OOPJBattleGrounds {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt(), max = 0, min = Integer.MAX_VALUE;
        int[] l1 = new int[n];
        int sum = 0;
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            l1[i] = sc.nextInt();
            sum += l1[i];
        }
        for (int i = 0; i < n; i++) {
            System.out.print(l1[i]+" ");
            if(l1[i]>max)   max = l1[i];
            if(l1[i]<min)   min = l1[i];
        }
        System.out.println();
        double median = sum/n;
        System.out.printf("%.2f\n",median);
        System.out.println(max);
        System.out.println(min);
    }
}
