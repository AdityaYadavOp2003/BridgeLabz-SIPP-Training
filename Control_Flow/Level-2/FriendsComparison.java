import java.util.Scanner;

public class FriendsComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int amarAge = sc.nextInt();
        int akbarAge = sc.nextInt();
        int anthonyAge = sc.nextInt();
        
        double amarHeight = sc.nextDouble();
        double akbarHeight = sc.nextDouble();
        double anthonyHeight = sc.nextDouble();
        
        int youngestAge = Math.min(Math.min(amarAge, akbarAge), anthonyAge);
        double tallestHeight = Math.max(Math.max(amarHeight, akbarHeight), anthonyHeight);
        
        System.out.println("Youngest friend age: " + youngestAge);
        System.out.println("Tallest friend height: " + tallestHeight);
    }
} 