import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String doc = sc.nextLine();
        String search = sc.nextLine();

        String str = doc.replace(search, "*");
        int ans = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '*') ans++;
        }
        System.out.println(ans);
    }
}
