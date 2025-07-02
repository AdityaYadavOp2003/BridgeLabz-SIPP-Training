package Level3;

import java.util.*;

public class CalendarDisplay {
    static String[] months = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    static int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    public static int getDaysInMonth(int month, int year) {
        if (month == 2 && isLeapYear(year)) return 29;
        return days[month];
    }
    public static int getFirstDay(int month, int year) {
        int y = year, m = month;
        if (m < 3) { m += 12; y--; }
        int k = y % 100, j = y / 100;
        int h = (1 + (13 * (m + 1)) / 5 + k + k/4 + j/4 + 5*j) % 7;
        return (h + 6) % 7; // 0=Sunday
    }
    public static void displayCalendar(int month, int year) {
        System.out.println("    " + months[month] + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        int firstDay = getFirstDay(month, year);
        int numDays = getDaysInMonth(month, year);
        for (int i = 0; i < firstDay; i++) System.out.print("    ");
        for (int day = 1; day <= numDays; day++) {
            System.out.printf("%3d ", day);
            if ((day + firstDay) % 7 == 0) System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = scn.nextInt();
        System.out.print("Enter year: ");
        int year = scn.nextInt();
        displayCalendar(month, year);
    }
}
