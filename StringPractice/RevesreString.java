package StringPractice;

import java.util.Scanner;

public class RevesreString {
    public static String reverse(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--)
            reversed += str.charAt(i);
        return reversed;
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String str= s.next();
        String res= reverse(str);
        System.out.println(res);
    }
}
