

public class CompareStringBufferStringBuilder {
    public static void main(String[] args) {
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
    }
} 