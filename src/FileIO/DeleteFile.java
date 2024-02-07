package FileIO;

import java.io.File;

public class DeleteFile {
    public static void main(String[] args) {
        File file=new File("C:\\Users\\GAUTHAM SHARMA\\OneDrive\\Documents\\JavaPracticeTextFile.txt");
        if(file.delete()){
            System.out.println("File "+file.getName()+" has been deleted");
        }else{
            System.out.println("Failed to delete file");
        }
    }
}
