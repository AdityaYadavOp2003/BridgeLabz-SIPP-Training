package StringPractice;

import java.util.Scanner;

public class ReplaceWord {
    public static String replaceWord(String sentence, String target, String replacement) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (word.equals(target))
                result.append(replacement);
            else
                result.append(word);
            result.append(" ");
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String text=s.nextLine();
        String target= s.next();
        String repalce= s.next();
        String res= replaceWord(text,target,repalce);
        System.out.println(res);
    }
}
