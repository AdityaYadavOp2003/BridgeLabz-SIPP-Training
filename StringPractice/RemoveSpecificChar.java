package StringPractice;

import java.util.Scanner;

public class RemoveSpecificChar {
    public static String removeCharacter(String str, char ch) {
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c != ch)
                result.append(c);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String str= s.next();
        char del=s.next().charAt(0);
        String res= removeCharacter(str,del);
        System.out.println(res);
    }
}
