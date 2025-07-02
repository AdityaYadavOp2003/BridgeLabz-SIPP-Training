package StringPractice;

public class ToggleCase {
    public static String toggleCase(String str) {
        StringBuilder toggled = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (Character.isUpperCase(ch))
                toggled.append(Character.toLowerCase(ch));
            else if (Character.isLowerCase(ch))
                toggled.append(Character.toUpperCase(ch));
            else
                toggled.append(ch);
        }
        return toggled.toString();
    }
}
