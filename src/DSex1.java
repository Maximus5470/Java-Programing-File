import java.util.Arrays;
import java.util.Scanner;

public class DSex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] n = {1, 2, 3, 4, 5};
        System.out.println(meanOfArray(n));
//        evenOrOdd(12, 17, 19, 14, 115, "odd");
//        int base = sc.nextInt();
//        int exponent = 0;
//        while (base != 0) {
//            exponent = exponent * 10 + base % 10;
//            base /= 10;
//        }
//        powerReverse(base,exponent);
    }

    // Sum of last digits of two numbers
    public static void sumLastDigits(int a, int b) {
        int sum = Math.abs(a % 10) + Math.abs(b % 10);
        System.out.println(sum);
    }

    // Is N exact multiple of M?
    public static void isMultiple(int n, int m) {
        if (n == 0 || m == 0) {
            System.out.println(3);
        } else if (n % m == 0) {
            System.out.println(2);
        } else {
            System.out.println(1);
        }
    }

    // Combine Strings
    public static void combineStrings(String a, String b) {
        System.out.println(a + b + a);
    }

    // Even or Odd
    public static void evenOrOdd(int n1, int n2, int n3, int n4, int n5, String type) {
        int[] arr = {n1, n2, n3, n4, n5};
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (type.equals("even") && arr[i] % 2 == 0) {
                count++;
            } else if (type.equals("odd") && arr[i] % 2 != 0) {
                count++;
            }
        }
        System.out.println(count);
    }

    // Second last digit of the number
    public static void secondLastDigit(int n) {
        if (n < 10) {
            System.out.println(-1);
        } else {
            System.out.println((n / 10) % 10);
        }
    }

    // Alternating String Combiner
    public static void alternatingStringCombiner(String a, String b) {
        int len = Math.min(a.length(), b.length());
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < len; i++) {
            res.append(a.charAt(i));
            res.append(b.charAt(i));
        }
        if (a.length() > b.length()) {
            res.append(a.substring(len));
        } else {
            res.append(b.substring(len));
        }
        System.out.println(res);
    }

    // Padovan Series
    public static void padovanSeries(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 1;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 2] + arr[i - 3];
        }
        for (int i = 0; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\b");
    }

    // Leaders in the array
    public static void findArrayLeaders(int n, int[] arr) {
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = n - 1; j > i; j--) {
                if (arr[i] < arr[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.print("\b");
    }


    // Number raised to its reverse
    public static void powerReverse(int base, int exponent) {
        int modulus = 1000000007;
        long result = 1;
        long power = base % modulus;

        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = (result * power) % modulus;
            }
            power = (power * power) % modulus;
            exponent >>= 1;
        }
        System.out.println(result);
    }

    // Mean of arrays using recursion
    public static double meanOfArray(int[] arr) {
        return (arr.length == 0) ? 0 : (meanOfArray(Arrays.copyOfRange(arr, 1, arr.length)) * (arr.length - 1) + arr[0]) / arr.length;
    }
}
