import java.util.Scanner;

public class HextoInt {
    public static void main(String[] args) {
        bintodec();
    }
    public static void hextobin(){
        Scanner sc=new Scanner(System.in);
        String hex1=sc.nextLine();
        if(hex1.matches("[0-9A-Fa-f]+")){
            int hex=Integer.parseInt(hex1,16);
            //System.out.println(hex);      if you want to convert hex to int
            String binary=Integer.toBinaryString(hex);
            System.out.println(binary);
        }else{
            System.out.println(-1);
        }
    }
    public static void bintodec(){
        Scanner sc=new Scanner(System.in);
        String bin=sc.nextLine();
        if(bin.matches("[0,1]+")){
            int bin1=Integer.parseInt(bin,2);
            System.out.println(bin1);
        }else{
            System.out.println(-1);
        }
    }
    public static void bintohex(){
        Scanner sc =new Scanner(System.in);
        String bin=sc.nextLine();
        if(bin.matches("[0,1]+")) {
            int bin1 = Integer.parseInt(bin, 2);
            System.out.println(Integer.toHexString(bin1).toUpperCase());
        }else{
            System.out.println(-1);
        }
    }
    public static void dectohex(){
        Scanner sc=new Scanner(System.in);
        int dec=sc.nextInt();
        int rem;
        String hex="";
        char[] hexchars={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(dec>0){
            rem=dec%16;
            hex=hexchars[rem]+hex;
            dec/=16;
        }
        System.out.println(hex);
    }
    public static void exactdigits(){
        Scanner sc=new Scanner(System.in);
        int n1= sc.nextInt();
        String n=Integer.toString(n1);
        for (int i = 0; i <n.length(); i++) {
            System.out.print(n.charAt(i)+" ");
        }
    }
    public static void revint(){
        Scanner sc=new Scanner(System.in);
        try {
            int a=sc.nextInt();
            while(a>0) {
                System.out.print(a % 10);
                a /= 10;
            }
        }catch (Exception e){
            System.out.println("Invalid");
        }
    }
    public static void palindromicNum(){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String n1=Integer.toString(n);
        String res="";
        for (int i = 0; i < n1.length(); i++) {
            res=n1.charAt(i)+res;
        }
        System.out.println((Integer.parseInt(res)==n)?"Palindromic Number":"Not Palindromic Number");
    }
    public static void spyNum(){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int prod=1,sum=0;
        while(a>0){
            int rem=a%10;
            prod*=rem;
            sum+=rem;
            a/=10;
        }
        System.out.println((sum==prod)?"Spy Number":"Not Spy Number");
    }
    public static void uglyNum(){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int x=1;
        while(a!=1){
            if(a%2==0) {
                a /= 2;
            }else if(a%3==0){
                a/=3;
            }else if(a%5==0){
                a/=5;
            }else{
                System.out.println("Not Ugly Number");
                x=0;
                break;
            }
        }
        if(x==1) System.out.println("Ugly Number");
    }
    public static void caesarCode(){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int n=sc.nextInt();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ',' || str.charAt(i) == ' ') {
                System.out.print(str.charAt(i));
            } else {
                System.out.print((char) (str.charAt(i) + n));
            }
        }
    }
    public static void exchangeCipher(){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        char n1= sc.next().charAt(0);
        char n2=sc.next().charAt(0);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==n1){
                System.out.print(n2);
            }else if(s.charAt(i)==n2){
                System.out.print(n1);
            }else{
                System.out.print(s.charAt(i));
            }
        }
    }
}
