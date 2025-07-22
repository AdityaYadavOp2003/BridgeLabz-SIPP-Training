package searches;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
public class CountWordOccurrencesFileReader {
    public static void main(String[] args) throws IOException {
        String filePath = "sample.txt";
        String targetWord = "example";
        int wordCount = 0;
        FileReader fileReaderInstance = new FileReader(filePath);
        BufferedReader bufferedReaderInstance = new BufferedReader(fileReaderInstance);
        String currentLine;
        while ((currentLine = bufferedReaderInstance.readLine()) != null) {
            String[] wordsArray = currentLine.split("\\s+");
            for (String word : wordsArray) {
                if (word.equals(targetWord)) {
                    wordCount++;
                }
            }
        }
        bufferedReaderInstance.close();
        fileReaderInstance.close();
        System.out.println(wordCount);
    }
} 