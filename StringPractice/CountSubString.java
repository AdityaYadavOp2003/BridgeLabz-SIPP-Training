package StringPractice;

import java.util.Scanner;

public class CountSubString {
    public static int countOccurrences(String str, String sub) {
        int count = 0;
        for (int i = 0; i <= str.length() - sub.length(); i++) {
            if (str.substring(i, i + sub.length()).equals(sub))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        String str= s.next();
        String str2=s.next();
        int res=countOccurrences(str,str2);
        System.out.println(res);
    }
}
