package searches;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
public class ReadFileLineByLine {
    public static void main(String[] args) throws IOException {
        FileReader fileReaderInstance = new FileReader("sample.txt");
        BufferedReader bufferedReaderInstance = new BufferedReader(fileReaderInstance);
        String currentLine;
        while ((currentLine = bufferedReaderInstance.readLine()) != null) {
            System.out.println(currentLine);
        }
        bufferedReaderInstance.close();
        fileReaderInstance.close();
    }
} 