package Code365;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day6_Polish_Notation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String raw=sc.nextLine();     //[3 11 5 + -]    [2 3 11 + 5 - *]
        String[] values=raw.substring(1,raw.length()-1).split(" ");
        ArrayList<String> l1=new ArrayList<>(Arrays.asList(values));
        for(int j=0;j< values.length-3;j++){
            for (int i = 0; i < l1.size()-1; i++) {
                if (l1.get(i).equals("+") || l1.get(i).equals("-") || l1.get(i).equals("*") || l1.get(i).equals("/")) {
                    l1.set(i, operation(Float.parseFloat(l1.get(i - 2)), Float.parseFloat(l1.get(i - 1)), l1.get(i)));
                    l1.remove(i - 2);
                    l1.remove(i - 2);
                    System.out.println(l1);
                }
            }
            if(l1.size()==3){
                System.out.println(operation(Float.parseFloat(l1.get(0)), Float.parseFloat(l1.get(1)), l1.get(2)));
                break;
            }
        }
    }
    public static String operation(float n1,float n2,String operator){
        float count=0f;
        switch (operator){
            case "+"-> count=n1+n2;
            case "-"-> count=n1-n2;
            case "*"-> count=n1*n2;
            case "/"-> count=n1/n2;
        }
        return Float.toString(count);
    }
}