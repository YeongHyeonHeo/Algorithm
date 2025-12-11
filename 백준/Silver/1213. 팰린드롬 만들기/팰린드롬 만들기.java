import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();

    static String name;

    static void input() {
        name = scan.next();
    }

    static void pro() {
        // 알파벳 개수를 저장할 배열 (A~Z)
        int[] count = new int[26];
        for (char c : name.toCharArray()) {
            count[c - 'A']++;
        }

        // 팰린드롬의 중앙에 올 문자가 있는지 확인
        int oddCount = 0;
        char center = 0; // 중앙 문자
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) {
                oddCount++;
                center = (char) (i + 'A'); // 홀수인 경우 중앙에 배치될 문자 저장
            }
        }

        // 홀수 개의 문자가 2개 이상이면 팰린드롬 불가능
        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        // 팰린드롬 만들기
        StringBuilder left = new StringBuilder(); // 왼쪽 절반
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < count[i] / 2; j++) {
                left.append((char) (i + 'A')); // 절반씩 왼쪽에 배치
            }
        }

        // 완성된 팰린드롬 = 왼쪽 + (중앙 문자) + 왼쪽 뒤집은 것
        StringBuilder result = new StringBuilder();
        result.append(left);
        if (oddCount == 1) result.append(center);
        result.append(left.reverse());

        System.out.println(result);
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
    }
}