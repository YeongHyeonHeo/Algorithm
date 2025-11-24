import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();

    static int N, M, ans;
    static int[] arr, selected;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) arr[i] = scan.nextInt();
        selected = new int[4];
        ans = Integer.MIN_VALUE;
    }

    // N개 중 3개 고르기 (완전탐색)
    // 중복 X, 순서 X
    static void rec_func(int k) {
        if (k == 4) { // 3개 다 골랐을 때
            int sum = 0;
            for (int i = 1; i <= 3; i++) sum += arr[selected[i]]; // 카드 3장 합
            // 3장 합이 M 넘지 않는 경우에만
            if (sum <= M) ans = Math.max(ans, sum);
        } else {
            // 1 2 3, 1 2 4, 1 2 5 ~
            for (int cand = selected[k-1] + 1; cand <= N; cand++) {
                selected[k] = cand;
                rec_func(k + 1);
            }
        }
    }

    static void pro() {
        rec_func(1);
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