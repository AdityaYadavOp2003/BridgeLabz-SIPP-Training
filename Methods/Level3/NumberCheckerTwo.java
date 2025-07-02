package Level3;

import java.util.*;

public class NumberCheckerTwo {
    public static int countDigits(int n) {
        return String.valueOf(Math.abs(n)).length();
    }
    public static int[] getDigits(int n) {
        String s = String.valueOf(Math.abs(n));
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) digits[i] = s.charAt(i) - '0';
        return digits;
    }
    public static int sumDigits(int[] d) {
        int sum = 0; for (int x : d) sum += x; return sum;
    }
    public static int sumSquares(int[] d) {
        int sum = 0; for (int x : d) sum += Math.pow(x, 2); return sum;
    }
    public static boolean isHarshad(int n) {
        int[] d = getDigits(n);
        return n % sumDigits(d) == 0;
    }
    public static int[][] digitFrequency(int n) {
        int[] d = getDigits(n);
        int[] freq = new int[10];
        for (int x : d) freq[x]++;
        int[][] result = new int[10][2];
        for (int i = 0; i < 10; i++) { result[i][0] = i; result[i][1] = freq[i]; }
        return result;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scn.nextInt();
        int[] digits = getDigits(n);
        System.out.println("Count of digits: " + countDigits(n));
        System.out.println("Digits: " + Arrays.toString(digits));
        System.out.println("Sum of digits: " + sumDigits(digits));
        System.out.println("Sum of squares: " + sumSquares(digits));
        System.out.println("Harshad number: " + isHarshad(n));
        int[][] freq = digitFrequency(n);
        System.out.println("Digit frequencies:");
        for (int[] row : freq) if (row[1] > 0) System.out.println(row[0] + ": " + row[1]);
    }
}
