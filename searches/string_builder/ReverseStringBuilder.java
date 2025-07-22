package searches.string_builder;

public class ReverseStringBuilder {
    public static String reverseText(String inputText) {
        StringBuilder reversedBuilder = new StringBuilder();
        reversedBuilder.append(inputText);
        reversedBuilder.reverse();
        return reversedBuilder.toString();
    }
    public static void main(String[] args) {
        String originalText = "hello";
        String reversedText = reverseText(originalText);
        System.out.println(reversedText);
    }
} 