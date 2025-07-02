package StringPractice;

import java.util.*;

public class AnagramCheck {
    public static boolean areAnagrams(String str1, String str2) {
        char[] a = str1.replaceAll("\\s+", "").toCharArray();
        char[] b = str2.replaceAll("\\s+", "").toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }

    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        String str1= s.next();
        String str2=s.next();
        Boolean res= areAnagrams(str1,str2);
        System.out.println(res);
    }
}
