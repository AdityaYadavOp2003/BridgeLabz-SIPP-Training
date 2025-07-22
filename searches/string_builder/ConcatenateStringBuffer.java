package string_builder;

public class ConcatenateStringBuffer {
    public static String concatenateStrings(String[] stringArray) {
        StringBuffer concatenatedResult = new StringBuffer();
        for (String currentString : stringArray) {
            concatenatedResult.append(currentString);
        }
        return concatenatedResult.toString();
    }
    public static void main(String[] args) {
        String[] wordsArray = {"Java", "is", "efficient"};
        String resultString = concatenateStrings(wordsArray);
        System.out.println(resultString);
    }
} 