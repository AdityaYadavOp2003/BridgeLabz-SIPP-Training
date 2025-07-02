package StringPractice;

import java.util.Scanner;

public class LexicographicalCompare {
    public static String compare(String str1, String str2) {
        int len = Math.min(str1.length(), str2.length());
        for (int i = 0; i < len; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return str1.charAt(i) < str2.charAt(i) ? str1 + " comes before " + str2
                        : str2 + " comes before " + str1;
            }
        }
        return str1.length() < str2.length() ? str1 + " comes before " + str2
                : (str1.equals(str2) ? "Both strings are equal"
                : str2 + " comes before " + str1);
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String str1=s.next();
        String str2= s.next();
        String res= compare(str1,str2);
        System.out.println(res);
    }
}
