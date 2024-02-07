package FileIO;

import java.io.File;
import java.io.IOException;

public class FileAccessCreation {
    public static void main(String[] args) {
        try {
            File file=new File("C:\\Users\\GAUTHAM SHARMA\\OneDrive\\Documents\\JavaPracticeTextFile.txt");
            if(file.createNewFile()){
                System.out.println("File created with name "+file.getName());
            }else{
                System.out.println("File already exists");
            }
        }catch (IOException e) {
            System.out.println("An error occurred");
        }
    }
}