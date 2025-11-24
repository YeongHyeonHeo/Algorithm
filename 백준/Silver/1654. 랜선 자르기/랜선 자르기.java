import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int K, N;
    static int[] A;

    static void input() {
        K = scan.nextInt();
        N = scan.nextInt();
        A = new int[K + 1];
        for (int i = 1; i <= K; i++) A[i] = scan.nextInt();
    }

    // 매개변수 탐색
    // 원래 문제: 랜선 N개를 만들 수 있는 랜선 최대 길이는 얼마?
    // 뒤집은 문제: 랜선 최대 길이(어떤 길이)로 자르면 N개를 만들 수 있는가? Yes/No
    static boolean determination(long len) {
        long sum = 0;
        for (int i = 1; i <= K; i++) {
            if (A[i] >= len) sum += A[i] / len;
        }
        return sum >= N;
    }

    static void pro() {
        long L = 1, R = Integer.MAX_VALUE, ans = 0;
        while (L <= R) {
            long mid = (L + R) / 2;
            if (determination(mid)) {
                ans = mid;
                L = mid + 1;
            } else R = mid - 1;
        }
        System.out.println(ans);
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