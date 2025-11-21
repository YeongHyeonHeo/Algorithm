import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    // HashMap 이용
    // key: 카드에 적힌 숫자, value: 해당 카드 개수
    static HashMap<Integer, Integer> hashMap = new HashMap<>();

    static void input() {
        N = scan.nextInt();
        while (N-- > 0) {
            int num = scan.nextInt();
            // 중복된 카드라면, value(카드 개수) 1 증가
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        M = scan.nextInt();
    }

    static void pro() {
        // 각 숫자카드 몇 개인지 출력
        while (M-- > 0) {
            int num = scan.nextInt();
            sb.append(hashMap.getOrDefault(num, 0)).append(' ');
        }
        System.out.println(sb);
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

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}