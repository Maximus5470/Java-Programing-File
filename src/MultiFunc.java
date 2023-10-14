import java.lang.Math;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MultiFunc {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number: ");
        int a=sc.nextInt();
        MultiFunc obj=new MultiFunc();
        boolean c=obj.prime(a);
        System.out.println(c);
        /*for (int i = 0; i < a; i++) {
            System.out.println(fib(i));     //for fibonacci series
        }*/
    }
    public void decToBin(int a){
        int i=1;
        int bin=0;
        while(a!=0){
            int rem=a%2;
            a/=2;
            bin+=rem*i;
            i*=10;
        }
        System.out.print(bin);
    }
    public double harmonicSum(int n){
        double s=0;
        for (double i = 1; i <=n; i++) {
            s+=1/i;
        }
        return s;
    }
    public double computePi(int n){
        double sum=0;
        for (double i = 0; i <= n; i++) {
            if(i%2==0){
                sum+=1/(2*i+1);
            }
            if(i%2!=0){
                sum-=1/(2*i+1);
            }
        }
        return 4*sum;
    }
    public int fib(int n) {
        if(n == 0) return 0;
        if(n==1||n==2) return 1;

        return fib(n-1)+fib(n-2);
    }
    public void exactDigits(String n){
        for (int i = 0; i < n.length(); i++) {
            System.out.print(n.charAt(i)+" ");
        }
    }
    public void amicable(int a,int b){
        int sum1=0,sum2=0;
        for (int i = 1; i < a; i++) {
            if(a%i==0) sum1+=i;
        }
        for (int i = 1; i < b; i++) {
            if(b%i==0) sum2+=i;
        }
        System.out.println((a==sum2 && b==sum1)?"Amicable":"Not Amicable");
    }
    public void armstrong(int n){
        int sum=0,count=0,rem=0,temp=n,temp2=n;
        while(n!=0){
            n/=10;
            count++;
        }
        while(temp!=0){
            rem=temp%10;
            sum+= (int) Math.pow(rem,count);
            temp/=10;
        }
        System.out.println((temp2==sum)?"Armstrong number":"Not Armstrong number");
    }
    public void capricorn(int n){
        int sq=n*n;
        int temp=sq;
        int count=0;
        boolean iscap=false;
        while(temp!=0){ //counting digits of sq
            temp/=10;
            count++;
        }
        for(int i=10;i<Math.pow(10,count);i*=10){
            int rest=sq/i;
            int rem=sq%i;
            if(rem+rest==n) {
                iscap=true;
                break;
            }
        }
        System.out.println((iscap)?"Capricorn Number":"Not Capricorn Number");
    }
    public boolean prime(int n){
        boolean isprime=false;
        if(n==1||n==0){
            System.out.println("not prime");
        }

        for (int i = 2; i <= n; i++) {
            if(n%i==0){
                if(i==n){
                    isprime=true;
                }else{
                    isprime=false;
                    break;
                }
            }
        }
        return isprime;
    }
    public void circularPrime(int n){
        int temp=n;
        int count=0;
        boolean x=false;
        while(temp!=0){ //counting digits of sq
            temp/=10;
            count++;
        }
        int pow=(int)Math.pow(10,count-1);
        for (int i = 0; i < count; i++) {
            int rem=n%10;
            n/=10;
            n+=rem*pow;
            x=prime(n);
        }
        System.out.println((x)?"Circular prime":"Not Circular prime");
    }
    public void happyNum(int n){
        if(n==1){
            System.out.println("Happy number");
            return;
        }
        if(n==4){
            System.out.println("Not Happy number");
            return;
        }
        int sum=0;
        while(n>0){
            int rem=n%10;
            sum+=rem*rem;
            n/=10;
        }
        happyNum(sum);
    }
    public void automorphicNum(int n){
        int sq=n*n;
        String sps=Integer.toString(sq);
        String ns=Integer.toString(n);

        Pattern pattern=Pattern.compile(ns);
        Matcher matcher=pattern.matcher(sps);
        System.out.println((matcher.find())?"Automorphic number":"Not Automorphic number");
    }
    public void disariumNum(int n) {
        int sum=0,count=0,rem=0,temp=n,temp2=n;
        while(n!=0){
            n/=10;
            count++;
        }
        while(temp!=0){
            rem=temp%10;
            sum+= (int) Math.pow(rem,count);
            temp/=10;
            count--;    //armstrong number code with this additional line
        }
        System.out.println((temp2==sum)?"Disarium number":"Not Disarium number");
    }
    public void magicNum(int n){
        if(n%9==1){
            System.out.println("Magic number");
            return;
        }
        if(n%9!=1){
            System.out.println("Not Magic number");
            return;
        }
        int sum=0;
        while(n>0){
            int rem=n%10;
            sum+=rem;
            n/=10;
        }
        happyNum(sum);
    }
    public void magic2(int n){
        int count=0;
        int temp=n;
        int temp2=n;

        while(temp!=0){
            temp/=10;   //counting digits
            count++;
        }
        int rev=(int) (n%Math.pow(10,count/2));
        n/=n%Math.pow(10,count/2);
        if(n*rev==temp2){
            System.out.println("Magic number");
        }else{
            System.out.println("Nope");
        }
    }
}