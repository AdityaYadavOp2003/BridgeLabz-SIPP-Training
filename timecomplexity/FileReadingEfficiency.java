package timecomplexity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class FileReadingEfficiency {
    public static void main(String[] args) throws Exception {
        String filePath = "timecomplexity/readme.md";
        long fileReaderStart = System.nanoTime();
        FileReader characterStreamReader = new FileReader(new File(filePath));
        while (characterStreamReader.read() != -1) {}
        characterStreamReader.close();
        long fileReaderEnd = System.nanoTime();
        long fileReaderDuration = fileReaderEnd - fileReaderStart;
        long inputStreamReaderStart = System.nanoTime();
        InputStreamReader byteStreamReader = new InputStreamReader(new FileInputStream(filePath));
        while (byteStreamReader.read() != -1) {}
        byteStreamReader.close();
        long inputStreamReaderEnd = System.nanoTime();
        long inputStreamReaderDuration = inputStreamReaderEnd - inputStreamReaderStart;
        System.out.println("FileReader Time: " + fileReaderDuration + " ns");
        System.out.println("InputStreamReader Time: " + inputStreamReaderDuration + " ns");
    }
} 