package Code365;

import java.util.Scanner;

public class Day3_IP_Address_Enigma {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();

        int p1,p2,p3,p4;
        for (int i = 1; i < str.length(); i++) {
            for (int j = i+1; j < str.length(); j++) {
                for (int k = j+1; k < str.length(); k++) {
                    p1= Integer.parseInt(str.substring(0,i));
                    p2= Integer.parseInt(str.substring(i,j));
                    p3= Integer.parseInt(str.substring(j,k));
                    p4= Integer.parseInt(str.substring(k));
                    if(p1<=255 && p2<=255 && p3<=255 && p4<=255){
                        System.out.println(p1+"."+p2+"."+p3+"."+p4);
                    }
                }
            }
        }
    }
}
