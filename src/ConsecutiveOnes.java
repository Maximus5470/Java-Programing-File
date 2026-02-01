import java.util.Scanner;

public class ConsecutiveOnes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int count = 0;
//        int times = (int)Math.pow(2,n);
//
//        for (int i = 0; i < times; i++) {
//            String bin = Integer.toBinaryString(i);
//            if (!bin.matches(".*11.*")) {
//                count++;
//            }
//        }
//
//        System.out.println(count);

        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println(arr[n]);
    }
}
