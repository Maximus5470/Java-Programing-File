import java.util.Scanner;

public class NumberSystemConversion {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String num=sc.next();
        int base1=sc.nextInt();
        int base2=sc.nextInt();
        int conv1=toInt(num,base1);
        toNum(conv1,base2);
    }
    public static int toInt(String num, int base1){
        return Integer.parseInt(num,base1);
    }
    public static void toNum(int num,int base2){
        switch (base2){
            case 2 -> System.out.println(Integer.toBinaryString(num));
            case 8 -> System.out.println(Integer.toOctalString(num));
            case 10 -> System.out.println(num);
            case 16 -> System.out.println(Integer.toHexString(num));
            default -> System.out.println("Invalid Base Value");
        }
    }
}
