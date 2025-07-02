package StringPractice;

import java.util.Scanner;

public class DuplicateRemove {
    public static String removeDuplicates(String str) {
        String result = "";
        for (char c : str.toCharArray()) {
            if (result.indexOf(c) == -1)
                result += c;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String str= s.next();
        String res=removeDuplicates(str);
        System.out.println(res);
    }
}
