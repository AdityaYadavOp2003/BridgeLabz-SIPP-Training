package StringPractice;

import java.util.Scanner;

public class MostFrequentChar {
    public static char mostFrequentChar(String str) {
        int[] freq = new int[256];
        for (char c : str.toCharArray())
            freq[c]++;
        int maxFreq = 0;
        char result = '\0';
        for (char c : str.toCharArray()) {
            if (freq[c] > maxFreq) {
                maxFreq = freq[c];
                result = c;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String str= s.next();
        char res=mostFrequentChar(str);
        System.out.println(res);
    }
}
