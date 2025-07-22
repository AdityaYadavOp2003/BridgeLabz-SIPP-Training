package searches;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
public class ReadUserInputWriteToFile {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReaderInstance = new InputStreamReader(System.in);
        BufferedReader bufferedReaderInstance = new BufferedReader(inputStreamReaderInstance);
        FileWriter fileWriterInstance = new FileWriter("output.txt");
        String userInput;
        while (!(userInput = bufferedReaderInstance.readLine()).equals("exit")) {
            fileWriterInstance.write(userInput + System.lineSeparator());
        }
        fileWriterInstance.close();
        bufferedReaderInstance.close();
        inputStreamReaderInstance.close();
    }
} 