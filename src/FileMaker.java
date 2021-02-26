import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileMaker extends WriteToFile{
    String fileName;
    String path = "C:\\Users\\SørenBendtsen\\Documents\\Github\\JavaMultiThread2.Sem\\Files\\" + fileName +".txt";



    public ArrayList<File> createFile(int amount) throws IOException {
        ArrayList<File> files = new ArrayList();

        for (int i = 0; i <= amount; i++) {
            fileName = "file" + i;
            File file = new File("path");
            file.createNewFile();
            files.add(file);
            writeToFile(path ,fileName +".txt");

        }
        return files;
    }

    public void deleteFiles(int amount) throws IOException {
        for (int i = 0; i <= amount; i++) {
            fileName = "file" +i;
            File file = new File(path + fileName + ".txt" );
            file.delete();
        }
    }

}
