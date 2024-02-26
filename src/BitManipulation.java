import java.util.*;

public class BitManipulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int position = sc.nextInt();
        int bitMask = 1 << position;
        System.out.println((bitMask & n) == 0 ? "0" : "1"); //check bit value at "position" using "and"

        int setNum = n | bitMask;
        System.out.println(setNum); //changing the bit to 1 using "or"

        int clearNum = ~bitMask & n;
        System.out.println(clearNum); //changing the bit to zero using "not" and "and"
    }
}
