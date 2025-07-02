package Level3;

import java.util.*;

public class NumberCheckerThree {
    public static int countDigits(int n) {
        return String.valueOf(Math.abs(n)).length();
    }
    public static int[] getDigits(int n) {
        String s = String.valueOf(Math.abs(n));
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) digits[i] = s.charAt(i) - '0';
        return digits;
    }
    public static int[] reverse(int[] d) {
        int[] rev = new int[d.length];
        for (int i = 0; i < d.length; i++) rev[i] = d[d.length - 1 - i];
        return rev;
    }
    public static boolean arraysEqual(int[] a, int[] b) {
        return Arrays.equals(a, b);
    }
    public static boolean isPalindrome(int n) {
        int[] d = getDigits(n);
        return arraysEqual(d, reverse(d));
    }
    public static boolean isDuck(int n) {
        int[] d = getDigits(n);
        for (int i = 1; i < d.length; i++) if (d[i] == 0) return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scn.nextInt();
        int[] digits = getDigits(n);
        System.out.println("Count of digits: " + countDigits(n));
        System.out.println("Digits: " + Arrays.toString(digits));
        System.out.println("Reversed: " + Arrays.toString(reverse(digits)));
        System.out.println("Palindrome: " + isPalindrome(n));
        System.out.println("Duck number: " + isDuck(n));
    }
}
