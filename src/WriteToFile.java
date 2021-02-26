import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {




    public void writeToFile(String path,String fileName) throws IOException {
        FileWriter fw = new FileWriter(path + fileName);

        for(int i = 0; i < 100000000; i++) {
            fw.write("SørensDiller");
        }
        fw.close();
    }
}
