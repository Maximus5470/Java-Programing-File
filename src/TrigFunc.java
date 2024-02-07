import java.util.Scanner;

public class TrigFunc {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        double theta=sc.nextInt();
        int noterms=sc.nextInt();
        //System.out.println(sinFunc((double)Math.toRadians(30),5));
        if(str.equals("sin")){
            System.out.println(sinFunc(Math.toRadians(theta),noterms));
        }else if(str.equals("cos")){
            System.out.println(cosFunc(Math.toRadians(theta),noterms));
        }else{
            System.out.println(sinFunc(Math.toRadians(theta),noterms)/cosFunc(Math.toRadians(theta),noterms));
        }
    }
    public static int fact(int n){
        return (n==0||n==1)? 1:n*fact(n-1);
    }
    public static double sinFunc(double n,int times){
        double sum=n;
        for (int i = 1; i < times; i++) {
            if(i%2==0){
                sum+=Math.pow(n,2*i+1)/fact(2*i+1);
            }else{
                sum-=Math.pow(n,2*i+1)/fact(2*i+1);
            }
        }
        return sum;
    }
    public static double cosFunc(double n,int times){
        double sum=1;
        for (int i = 1; i < times; i++) {
            if(i%2==0){
                sum+=Math.pow(n,2*i)/fact(2*i);
            }else{
                sum-=Math.pow(n,2*i)/fact(2*i);
            }
        }
        return sum;
    }
}
        /*HashMap<Character,String> map= new HashMap<>();
        map.put('0',"0000");
        map.put('1',"0001");
        map.put('2',"0010");
        map.put('3',"0011");
        map.put('4',"0100");
        map.put('5',"0101");
        map.put('6',"0110");
        map.put('7',"0111");
        map.put('8',"1000");
        map.put('9',"1001");
        map.put('a',"1010");
        map.put('b',"1011");
        map.put('c',"1100");
        map.put('d',"1101");
        map.put('e',"1110");
        map.put('f',"1111");
        String str= new Scanner(System.in).nextLine().toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            System.out.print(map.get(str.charAt(i))+" ");
            switch (a){
                case '0'-> System.out.print(s[0]);
                case '1'-> System.out.print(s[1]);
                case '2'-> System.out.print(s[2]);
                case '3'-> System.out.print(s[3]);
                case '4'-> System.out.print(s[4]);
                case '5'-> System.out.print(s[5]);
                case '6'-> System.out.print(s[6]);
                case '7'-> System.out.print(s[7]);
                case '8'-> System.out.print(s[8]);
                case '9'-> System.out.print(s[9]);
                case 'a'-> System.out.print(s[10]);
                case 'b'-> System.out.print(s[11]);
                case 'c'-> System.out.print(s[12]);
                case 'd'-> System.out.print(s[13]);
                case 'e'-> System.out.print(s[14]);
                case 'f'-> System.out.print(s[15]);
            }*/

        /*Scanner sc=new Scanner(System.in);
        double res=0;
        while(true) {
            res = sc.nextDouble();
            if (res != -1) {
                double interest = 0.07;
                double p = (double) (res / (1 + interest));
                System.out.printf("%.2f %.2f\n", p, (res - p));
            } else {
                break;
            }
        }*/