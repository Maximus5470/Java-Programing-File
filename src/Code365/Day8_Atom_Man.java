package Code365;

import java.util.Scanner;

public class Day8_Atom_Man {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();;
        sc.nextLine();
        int minval=Integer.MAX_VALUE;
        int[] vals= new int[n];
        for (int i = 0; i < n; i++) {
            vals[i]=sc.nextInt();
        }
        for (int i = 0; i < vals.length; i++) {
            for (int j = 0; j < vals.length; j++) {
                if(i==j)    continue;
                int rem=vals[i]-vals[j];
                if(rem<0)   rem*=-1;
                if(rem<minval)  minval=rem;
            }
        }
        System.out.println(minval);
    }
}
