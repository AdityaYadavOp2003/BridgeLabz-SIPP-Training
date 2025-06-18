import java.util.Scanner;

public class DistanceConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double feet = input.nextDouble();
        double yards = feet / 3;
        double miles = yards / 1760;
        System.out.println("The distance in feet is " + feet + " while in yards is " + yards + " and miles is " + miles);
    }
} 