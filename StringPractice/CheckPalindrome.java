package StringPractice;

import java.util.Scanner;

public class CheckPalindrome {
    public static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        String str= s.next();
        boolean res=isPalindrome(str);
        System.out.println(res);
    }
}
