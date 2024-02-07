package FileIO;

import java.io.*;
import java.util.Scanner;

public class FileReading {
    public static void main(String[] args) throws IOException {
//byte streams
        FileInputStream reader= new FileInputStream("C:\\Users\\GAUTHAM SHARMA\\OneDrive\\Documents\\JavaPracticeTextFile.txt");
        int c=0;
        while((c= reader.read())!=-1){
            System.out.print((char)c);
        }

//character streams
        /*try{
            FileReader reader=new FileReader("C:\\Users\\GAUTHAM SHARMA\\OneDrive\\Documents\\JavaPracticeTextFile.txt");
            int i=0;
            while((i=reader.read())!=-1){
                System.out.print((char)i);
            }
        }catch (IOException e){
            System.out.println("An error has occurred...");
        }*/
    }
}
