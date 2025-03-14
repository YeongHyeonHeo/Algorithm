import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        int[] countWord = new int[26];

        for (int i = 0; i < word.length(); i++) {
            if ('A' <= word.charAt(i) && word.charAt(i) <= 'Z') {
                countWord[word.charAt(i) - 'A']++;
            }
            else {
                countWord[word.charAt(i) - 'a']++;
            }
        }

        int max = 0;
        int index = 0;
        for (int i = 0; i < 26; i++) {
            if (countWord[i] > max) {
                max = countWord[i];
                index = i;
            }
        }

        int same = 0;
        for (int i : countWord) {
            if (i == max) same++;
        }

        if (same == 1) {
            System.out.println((char)('A' + index));
        } else {
            System.out.println("?");
        }
    }
}
