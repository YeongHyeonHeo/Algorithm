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
        String word = sc.next();
        String word2 = sc.next();

        int[] countA = getAlphabetCount(word);
        int[] countB = getAlphabetCount(word2);

        int ans = 0;
        for (int i = 0; i < 26; i++){
            ans += Math.abs(countA[i] - countB[i]);
        }
        System.out.println(ans);
    }
}
