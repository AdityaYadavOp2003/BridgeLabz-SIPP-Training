package StringPractice;

import java.util.Arrays;
import java.util.Scanner;

public class VowelConsonantCount {
    public static int[] countVowelsAndConsonants(String str) {
        int vowels = 0, consonants = 0;
        str = str.toLowerCase();
        for (char ch : str.toCharArray()) {
            if (Character.isLetter(ch)) {
                if ("aeiou".indexOf(ch) != -1)
                    vowels++;
                else
                    consonants++;
            }
        }
        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        String str=s.next();
        int[] res= countVowelsAndConsonants(str);
        System.out.println(Arrays.toString(res));
    }
}
