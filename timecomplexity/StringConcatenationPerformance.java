package timecomplexity;

public class StringConcatenationPerformance {
    public static void main(String[] args) {
        int numberOfConcatenations = 10000;
        String stringResult = "";
        long stringStartTime = System.nanoTime();
        for (int index = 0; index < numberOfConcatenations; index++) {
            stringResult += "a";
        }
        long stringEndTime = System.nanoTime();
        long stringDuration = stringEndTime - stringStartTime;
        StringBuilder stringBuilderResult = new StringBuilder();
        long stringBuilderStartTime = System.nanoTime();
        for (int index = 0; index < numberOfConcatenations; index++) {
            stringBuilderResult.append("a");
        }
        long stringBuilderEndTime = System.nanoTime();
        long stringBuilderDuration = stringBuilderEndTime - stringBuilderStartTime;
        StringBuffer stringBufferResult = new StringBuffer();
        long stringBufferStartTime = System.nanoTime();
        for (int index = 0; index < numberOfConcatenations; index++) {
            stringBufferResult.append("a");
        }
        long stringBufferEndTime = System.nanoTime();
        long stringBufferDuration = stringBufferEndTime - stringBufferStartTime;
        System.out.println("String Time: " + stringDuration + " ns");
        System.out.println("StringBuilder Time: " + stringBuilderDuration + " ns");
        System.out.println("StringBuffer Time: " + stringBufferDuration + " ns");
    }
} 