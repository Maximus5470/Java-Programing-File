package Code365;

import java.util.Scanner;

public class Day1_Valid_HTML_Closing_Tag {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String raw=sc.nextLine();
        System.out.println(raw.matches("</[a-z]+>")?"Valid":"Invalid"); //</run>
    }
}
