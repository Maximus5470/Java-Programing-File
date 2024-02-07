package Code365;

import java.util.Scanner;

public class Day10_Inventory_Search {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        for (int i = 0; i < a; i++) {
            int size=sc.nextInt();
            int[] l1=new int[size];
            for (int j = 0; j < size; j++) {
                l1[j]=sc.nextInt();
            }
            int find=sc.nextInt();
            System.out.print(check(find,l1)+" ");
            System.out.println(reverseCheck(find,l1));
        }
    }
    public static int check(int find, int[] l1){
        for (int i = 0; i < l1.length; i++) {
            if(l1[i]==find){
                return i+1;
            }
        }
        return -1;
    }
    public static int reverseCheck(int find, int[] l1){
        for (int i = 0; i < l1.length; i++) {
            if(l1[l1.length-i-1]==find){
                return l1.length-i;
            }
        }
        return -1;
    }
}
