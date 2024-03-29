import java.lang.Math;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MultiFunc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int a = sc.nextInt();
        MultiFunc obj = new MultiFunc();
        System.out.println(obj.computePi(a));
        /*for (int i = 0; i < a; i++) {
            System.out.println(fib(i));     //for fibonacci series
        }*/
    }

    public int[] insertionSort(int[] ar1) {
        for (int i = 1; i < ar1.length; i++) {
            int current = ar1[i];
            int j = i - 1;
            while (j >= 0 && current < ar1[j]) {
                ar1[j+1]=ar1[j];
                j--;
            }
            ar1[j+1]=current;
        }
        return ar1;
    }

    public int[] selectionSort(int[] ar1) {
        for (int i = 0; i < ar1.length - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < ar1.length; j++) {
                if (ar1[smallest] > ar1[j]) smallest = j;
            }
            int temp = ar1[smallest];
            ar1[smallest] = ar1[i];
            ar1[i] = temp;
        }
        return ar1;
    }

    public int[] bubbleSort(int[] ar1) {
        for (int i = 0; i < ar1.length - 1; i++) {
            for (int j = 0; j < ar1.length - i - 1; j++) {
                if (ar1[j] > ar1[j + 1]) {
                    int temp = ar1[j];
                    ar1[j] = ar1[j + 1];
                    ar1[j + 1] = temp;
                }
            }
        }
        return ar1;
    }

    public void wordCamelCase(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int count=1;
        for (int i = 0; i < input.length(); i++) {
            if(input.substring(i, i + 1).equals(input.substring(i, i + 1).toUpperCase())) count++;
        }
        System.out.println(count);
    }

    public void arrayLeftShift(){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr=new int[size];
        int count=sc.nextInt();
        int i=0;

        for (int j = 0; j < size; j++) {
            arr[j]=sc.nextInt();
        }
        while (i!=count) {
            int first = arr[0];
            for (int j = 1; j < arr.length; j++) {
                arr[j-1]=arr[j];
            }
            arr[arr.length-1]=first;
            i++;
        }
        System.out.println(Arrays.toString(arr));
    }

    public void reduceString(){
        Scanner sc = new Scanner(System.in);
        StringBuilder input = new StringBuilder(sc.nextLine());
        while (true) {
            int prevsize = input.length();
            for (int i = 0; i < input.length() - 1; i++) {
                if (input.charAt(i) == input.charAt(i + 1)) {
                    input.replace(i, i + 2, "");
                    i--;
                }
            }
            if (input.length() == prevsize || input.isEmpty()) break;
            else prevsize = input.length();
        }
        System.out.println(input.isEmpty() ? "Empty String" : input);
    }
    public static void moveChar(char x, String input,int index, int count, String res){
        if(index==input.length()){
            for (int i = 0; i < count; i++) {
                res+=x;
            }
            System.out.println(res);
            return;
        }
        if(input.charAt(index)==x){
            count++;
            moveChar(x,input,index+1,count,res);
        }else{
            res+=input.charAt(index);
            moveChar(x,input,index+1,count,res);
        }
    }
    public void pangramCheck(){
        Scanner sc = new Scanner(System.in);
        char[] alphabet={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' '};
        String input = sc.nextLine().toLowerCase();
        input=input.replaceAll("(.)(?=.*\\1)","");
        System.out.println(input);
        int count=0;
        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if(input.charAt(i)==alphabet[j]) count++;
            }
        }
        System.out.println(count==27?"pangram":"not pangram");
    }

    public void decToBin(int a) {
        int i = 1;
        int bin = 0;
        while (a != 0) {
            int rem = a % 2;
            a /= 2;
            bin += rem * i;
            i *= 10;
        }
        System.out.print(bin);
    }

    public double harmonicSum(int n) {
        double s = 0;
        for (double i = 1; i <= n; i++) {
            s += 1 / i;
        }
        return s;
    }

    public double computePi(int n) {
        double sum = 0;
        for (double i = 0; i <= n; i++) {
            if (i % 2 == 0) {
                sum += 1 / (2 * i + 1);
            }
            if (i % 2 != 0) {
                sum -= 1 / (2 * i + 1);
            }
        }
        return 4 * sum;
    }

    public int fib(int n) {

        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        return fib(n - 1) + fib(n - 2);
    }

    public void exactDigits(String n) {
        for (int i = 0; i < n.length(); i++) {
            System.out.print(n.charAt(i) + " ");
        }
    }

    public void amicable(int a, int b) {
        int sum1 = 0, sum2 = 0;
        for (int i = 1; i < a; i++) {
            if (a % i == 0) sum1 += i;
        }
        for (int i = 1; i < b; i++) {
            if (b % i == 0) sum2 += i;
        }
        System.out.println((a == sum2 && b == sum1) ? "Amicable" : "Non Amicable");
    }

    public void armstrong(int n) {
        int sum = 0, count = 0, rem = 0, temp = n, temp2 = n;
        while (n != 0) {
            n /= 10;
            count++;
        }
        while (temp != 0) {
            rem = temp % 10;
            sum += (int) Math.pow(rem, count);
            temp /= 10;
        }
        System.out.println((temp2 == sum) ? "Armstrong number" : "Non Armstrong number");
    }

    public void capricorn(int n) {
        int sq = n * n;
        int temp = sq;
        int count = 0;
        boolean iscap = false;
        while (temp != 0) { //counting digits of sq
            temp /= 10;
            count++;
        }
        for (int i = 10; i < Math.pow(10, count); i *= 10) {
            int rest = sq / i;
            int rem = sq % i;
            if (rem + rest == n) {
                iscap = true;
                break;
            }
        }
        System.out.println((iscap) ? "Capricorn Number" : "Not Capricorn Number");
    }

    public boolean prime(int n) {
        boolean isprime = false;
        if (n == 1 || n == 0) {
            System.out.println("not prime");
        }

        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                if (i == n) {
                    isprime = true;
                } else {
                    break;
                }
            }
        }
        return isprime;
    }

    public void circularPrime(int n) {
        int temp = n;
        int count = 0;
        boolean x = false;
        while (temp != 0) { //counting digits of sq
            temp /= 10;
            count++;
        }
        int pow = (int) Math.pow(10, count - 1);
        for (int i = 0; i < count; i++) {
            int rem = n % 10;
            n /= 10;
            n += rem * pow;
            x = prime(n);
        }
        System.out.println(x ? "Circular prime" : "Not Circular prime");
    }

    public void happyNum(int n) {
        if (n == 1) {
            System.out.println("Happy number");
            return;
        }
        if (n == 4) {
            System.out.println("Not Happy number");
            return;
        }
        int sum = 0;
        while (n > 0) {
            int rem = n % 10;
            sum += rem * rem;
            n /= 10;
        }
        happyNum(sum);
    }

    public void automorphicNum(int n) {
        int sq = n * n;
        int temp = n, count = 0;
        while (temp > 0) {
            temp /= 10;
            count++;
        }
        System.out.println((sq % Math.pow(10, count) == n) ? "Automorphic" : "Not Automorphic");
    }

    public void disariumNum(int n) {
        int sum = 0, count = 0, rem = 0, temp = n, temp2 = n;
        while (n != 0) {
            n /= 10;
            count++;
        }
        while (temp != 0) {
            rem = temp % 10;
            sum += (int) Math.pow(rem, count);
            temp /= 10;
            count--;    //armstrong number code with this additional line
        }
        System.out.println((temp2 == sum) ? "Disarium number" : "Not Disarium number");
    }

    public void magicNum(int n) {
        if (n % 9 == 1) {
            System.out.println("Magic number");
            return;
        }
        if (n % 9 != 1) {
            System.out.println("Not Magic number");
            return;
        }
        int sum = 0;
        while (n > 0) {
            int rem = n % 10;
            sum += rem;
            n /= 10;
        }
        magicNum(sum);
    }

    public void perfectNum(int n) {
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) res += i;
        }
        System.out.println((res == n) ? "Perfect Number" : "Not Perfect Number");
    }

    public static int fact(int n) {
        return (n == 0 || n == 1) ? 1 : n * fact(n - 1);
    }

    public void specialNum(int n) {
        int temp = n;
        int sum = 0;
        while (temp != 0) {
            int res = temp % 10;
            temp /= 10;
            sum += fact(res);
        }
        System.out.println((sum == n) ? "Special Number" : "Not Special Number");
    }
}
