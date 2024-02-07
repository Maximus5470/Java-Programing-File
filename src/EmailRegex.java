import java.util.Scanner;

public class EmailRegex {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String email = sc.next();
        if(email.matches("^(\\w|\\d)+@(\\w|\\.)*\\.(com|edu|in)$")){
            System.out.println("Ohh Yeahh...");
        }else{
            System.out.println("Sike...");
        }
    }
}
//jayraj@gaymail.onlyfans.in