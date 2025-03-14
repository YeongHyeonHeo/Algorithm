import java.util.Scanner;

public class Main {
    public static int[] getAlphabetCount(String str){
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++){
            count[str.charAt(i) - 'a']++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        int[] countA = getAlphabetCount(a); // dared: [1, 0, 0, 2 .. ]
        int[] countB = getAlphabetCount(b);

        int ans = 0;
        for (int i = 0; i < 26; i++){
            ans += Math.abs(countA[i] - countB[i]); // 절대값
        }
        System.out.println(ans);
    }
}
