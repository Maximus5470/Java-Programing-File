import java.util.*;

public class GoldMine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m =  sc.nextInt();
        int[][] inp = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                inp[i][j] = sc.nextInt();
            }
        }

        int max_profit = 0;
        int x = 0, y = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cost = inp[i][j];

                try {cost += inp[i+1][j+1];}
                catch(Exception e) {}
                try {cost += inp[i-1][j+1];}
                catch(Exception e) {}
                try {cost += inp[i][j+1];}
                catch(Exception e) {}
                if (max_profit < cost) {
                    max_profit = cost;
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println(max_profit);
        System.out.println(x + ", " + y);
    }
}
