package searches.string_builder;
import java.util.HashSet;
public class RemoveDuplicatesStringBuilder {
    public static String removeDuplicateCharacters(String inputString) {
        StringBuilder uniqueCharacters = new StringBuilder();
        HashSet<Character> seenCharacters = new HashSet<>();
        for (char currentCharacter : inputString.toCharArray()) {
            if (!seenCharacters.contains(currentCharacter)) {
                uniqueCharacters.append(currentCharacter);
                seenCharacters.add(currentCharacter);
            }
        }
        return uniqueCharacters.toString();
    }
    public static void main(String[] args) {
        String inputText = "programming";
        String resultText = removeDuplicateCharacters(inputText);
        System.out.println(resultText);
    }
} 