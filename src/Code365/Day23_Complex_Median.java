package Code365;

import java.util.*;

public class Day23_Complex_Median {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1=sc.nextInt();
        int n2=sc.nextInt();
        ArrayList<Integer> l1 = new ArrayList<>();
        sc.nextLine();
        for (int i = 0; i < n1+n2; i++) {
            l1.add(sc.nextInt());
        }
        Collections.sort(l1);
        if(l1.size()%2==0){
            System.out.println(l1.get(l1.size()/2-1)+" "+l1.get(l1.size()/2));
        }else{
            System.out.println(l1.get((l1.size()-1)/2));
        }
    }
}
