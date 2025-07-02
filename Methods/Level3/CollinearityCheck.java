package Level3;

import java.util.*;

public class CollinearityCheck {
    public static boolean isCollinearSlope(int x1, int y1, int x2, int y2, int x3, int y3) {
        return (y2 - y1) * (x3 - x2) == (y3 - y2) * (x2 - x1);
    }
    public static boolean isCollinearArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        return area == 0.0;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter x1 y1: ");
        int x1 = scn.nextInt(), y1 = scn.nextInt();
        System.out.print("Enter x2 y2: ");
        int x2 = scn.nextInt(), y2 = scn.nextInt();
        System.out.print("Enter x3 y3: ");
        int x3 = scn.nextInt(), y3 = scn.nextInt();
        System.out.println("Collinear (Slope): " + isCollinearSlope(x1, y1, x2, y2, x3, y3));
        System.out.println("Collinear (Area): " + isCollinearArea(x1, y1, x2, y2, x3, y3));
    }
}
