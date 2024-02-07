package FileIO;

import java.io.IOException;
import java.io.FileWriter;

public class FileWriting {
    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("C:\\Users\\GAUTHAM SHARMA\\OneDrive\\Documents\\JavaPracticeTextFile.txt");
        writer.write("File writing is kinda tricky and annoying\n");
        writer.write("Yep, the previous line is spitting facts");
        writer.close();
        System.out.println("Text updated successfully");
    }
}
