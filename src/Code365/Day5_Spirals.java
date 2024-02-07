package Code365;

import java.util.Scanner;

public class Day5_Spirals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String raw=sc.nextLine();
        String[] values=raw.substring(2,raw.length()-2).split("\\],\\[");
        int[][] input=new int[values.length][values.length];
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length; j++) {
                input[i][j] = Integer.parseInt(values[i].split(",")[j]);    //converted string array into 2d int array
            }
        }   //[[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]
        //[[1,2,3,4,5],[6,7,8,9,10],[11,12,13,14,15],[16,17,18,19,20],[21,22,23,24,25]]
        for (int i = 0; i <= values.length; i++) {
            for (int j = i; j < values.length-i; j++) {
                System.out.print(input[i][j]+" ");                  //right
            }
            for (int j = i+1; j < values.length-i; j++) {
                System.out.print(input[j][values.length-i-1]+" ");  //down
            }
            for (int j = i+2; j < values.length+1-i; j++) {
                System.out.print(input[values.length-i-1][values.length-j]+" ");    //left
            }
            for (int j = i+2; j < values.length-i; j++) {
                System.out.print(input[values.length-j][i]+" ");    //up
            }
        }
    }
}
