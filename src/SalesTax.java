import java.util.Scanner;

public class SalesTax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        double res = 0;
        int i=0;

        for ( ; amount >= 20000; i++) {
            if(i>=3) res += 20000 * 0.3;
            else res += (double) (20000 * i) / 10;
            amount -= 20000;
        }
        
        if(i==0) System.out.printf("%.2f",res);
        if(i==1) System.out.printf("%.2f", res +amount*0.1);
        if(i==2) System.out.printf("%.2f",res +amount*0.2);
        if(i>=3) System.out.printf("%.2f",res +amount*0.3);
    }
}