package StringPractice;

import java.util.Scanner;

public class FindLongestWord {
    public static String findLongestWord(String sentence) {
        String[] words = sentence.split(" ");
        String longest = "";
        for (String word : words) {
            if (word.length() > longest.length())
                longest = word;
        }
        return longest;
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String str= s.nextLine();
        String res=findLongestWord(str);
        System.out.println(res);
    }
}
