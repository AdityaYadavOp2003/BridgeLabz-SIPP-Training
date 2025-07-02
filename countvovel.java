import java.util.Scanner;
public class countvovel {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int vovels=0 , consonents=0;

        for(int i =0;i<str.length();i++){
            if(str.charAt(i)=='a' || str.charAt(i)=='e' || str.charAt(i)=='i' || str.charAt(i)=='o'|| str.charAt(i)=='u'||
            str.charAt(i)=='A' || str.charAt(i)=='E' || str.charAt(i)=='I' || str.charAt(i)=='O'|| str.charAt(i)=='U')
            vovels++;
            else if (str.charAt(i)==' ')
            continue;
            else
            consonents++;
        }

        System.out.println("Total Vovels : " + vovels);
        System.out.println("Total Consonents : " + consonents);


        
    }
}