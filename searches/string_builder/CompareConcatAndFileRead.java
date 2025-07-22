
import java.io.*;
public class CompareConcatAndFileRead {
    public static void main(String[] args) throws Exception {
        int repeatCount = 1000000;
        String textToAppend = "hello";
        long startTimeBuffer = System.nanoTime();
        StringBuffer bufferInstance = new StringBuffer();
        for (int i = 0; i < repeatCount; i++) {
            bufferInstance.append(textToAppend);
        }
        long endTimeBuffer = System.nanoTime();
        long durationBuffer = endTimeBuffer - startTimeBuffer;
        long startTimeBuilder = System.nanoTime();
        StringBuilder builderInstance = new StringBuilder();
        for (int i = 0; i < repeatCount; i++) {
            builderInstance.append(textToAppend);
        }
        long endTimeBuilder = System.nanoTime();
        long durationBuilder = endTimeBuilder - startTimeBuilder;
        System.out.println("StringBuffer time: " + durationBuffer + " ns");
        System.out.println("StringBuilder time: " + durationBuilder + " ns");
        FileReader fileReaderInstance = new FileReader("largefile.txt");
        BufferedReader bufferedReaderInstance = new BufferedReader(fileReaderInstance);
        int wordCountFileReader = 0;
        String currentLine;
        while ((currentLine = bufferedReaderInstance.readLine()) != null) {
            String[] wordsArray = currentLine.split("\\s+");
            wordCountFileReader += wordsArray.length;
        }
        bufferedReaderInstance.close();
        fileReaderInstance.close();
        FileInputStream fileInputStreamInstance = new FileInputStream("largefile.txt");
        InputStreamReader inputStreamReaderInstance = new InputStreamReader(fileInputStreamInstance, "UTF-8");
        BufferedReader bufferedInputStreamReader = new BufferedReader(inputStreamReaderInstance);
        int wordCountInputStreamReader = 0;
        while ((currentLine = bufferedInputStreamReader.readLine()) != null) {
            String[] wordsArray = currentLine.split("\\s+");
            wordCountInputStreamReader += wordsArray.length;
        }
        bufferedInputStreamReader.close();
        inputStreamReaderInstance.close();
        fileInputStreamInstance.close();
        System.out.println("FileReader word count: " + wordCountFileReader);
        System.out.println("InputStreamReader word count: " + wordCountInputStreamReader);
    }
} 