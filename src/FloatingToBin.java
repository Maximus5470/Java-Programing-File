import java.util.Scanner;

public class FloatingToBin {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String num=sc.next();
        if(!num.matches("-?+\\d+(\\.+\\d+)?")) System.out.println(-1);
        else{
            double numdouble=Double.parseDouble(num);
            if(numdouble>=0){
                int wholepart=(int)numdouble;
                double decpart=numdouble-wholepart;
                System.out.println(Integer.toBinaryString(wholepart)+floatingToBin(decpart));
            }else{
                numdouble*=-1;
                int wholepart=(int)numdouble;
                double decpart=numdouble-wholepart;
                System.out.println("-"+Integer.toBinaryString(wholepart)+floatingToBin(decpart));
            }
        }
    }
    public static StringBuilder floatingToBin(double n){
        StringBuilder str=new StringBuilder(".");
        for (int i = 0; i < 22; i++) {
            n*=2;
            str.append((int)n);
            if(n==0)    break;
            n-=(int)n;
        }
        return str;
    }
}
