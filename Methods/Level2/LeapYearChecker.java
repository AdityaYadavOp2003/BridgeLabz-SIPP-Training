package Level2;

import java.util.*;

public class LeapYearChecker {
    public static boolean isLeapYear(int year) {
        if (year < 1582) return false;
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = scn.nextInt();
        if (isLeapYear(year)) System.out.println("Leap Year");
        else System.out.println("Not a Leap Year");
    }
}
