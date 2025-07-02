package Level3;

import java.util.*;

public class NumberCheckerOne {
    public static int countDigits(int n) {
        return String.valueOf(Math.abs(n)).length();
    }
    public static int[] getDigits(int n) {
        String s = String.valueOf(Math.abs(n));
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) digits[i] = s.charAt(i) - '0';
        return digits;
    }
    public static boolean isDuck(int n) {
        int[] d = getDigits(n);
        for (int i = 1; i < d.length; i++) if (d[i] == 0) return true;
        return false;
    }
    public static boolean isArmstrong(int n) {
        int[] d = getDigits(n);
        int sum = 0, pow = d.length;
        for (int x : d) sum += Math.pow(x, pow);
        return sum == n;
    }
    public static int[] largestTwo(int[] d) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for (int x : d) {
            if (x > max1) { max2 = max1; max1 = x; }
            else if (x > max2 && x != max1) max2 = x;
        }
        return new int[]{max1, max2};
    }
    public static int[] smallestTwo(int[] d) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int x : d) {
            if (x < min1) { min2 = min1; min1 = x; }
            else if (x < min2 && x != min1) min2 = x;
        }
        return new int[]{min1, min2};
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scn.nextInt();
        int[] digits = getDigits(n);
        System.out.println("Count of digits: " + countDigits(n));
        System.out.println("Digits: " + Arrays.toString(digits));
        System.out.println("Duck number: " + isDuck(n));
        System.out.println("Armstrong number: " + isArmstrong(n));
        int[] largest = largestTwo(digits);
        System.out.println("Largest: " + largest[0] + ", Second Largest: " + largest[1]);
        int[] smallest = smallestTwo(digits);
        System.out.println("Smallest: " + smallest[0] + ", Second Smallest: " + smallest[1]);
    }
}
