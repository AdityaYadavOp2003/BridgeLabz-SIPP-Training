package searches;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
public class ByteStreamToCharStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStreamInstance = new FileInputStream("sample.txt");
        InputStreamReader inputStreamReaderInstance = new InputStreamReader(fileInputStreamInstance, "UTF-8");
        BufferedReader bufferedReaderInstance = new BufferedReader(inputStreamReaderInstance);
        String currentLine;
        while ((currentLine = bufferedReaderInstance.readLine()) != null) {
            System.out.println(currentLine);
        }
        bufferedReaderInstance.close();
        inputStreamReaderInstance.close();
        fileInputStreamInstance.close();
    }
} 