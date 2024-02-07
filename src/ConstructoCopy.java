class Complex{
    private double re,im;
    public Complex(double re,double im){
        this.re=re;
        this.im=im;
    }
    public Complex(Complex c){      //sharingan of complex function #CopyJutsu
        re=c.re;
        im=c.im;
    }
    @Override
    public String toString(){
        return "("+re+"+"+im+"i)";
    }

}
public class ConstructoCopy {
    public static void main(String[] args) {
        Complex c1=new Complex(15,20);  //OG constructor
        Complex c2=new Complex(c1);     //copy constructor
        Complex c3=c2;  //non primitive variables are just references
        System.out.println(c3);
    }
}