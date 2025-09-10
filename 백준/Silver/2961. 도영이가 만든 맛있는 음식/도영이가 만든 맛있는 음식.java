import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, min;
    static int[][] food;
    static int[] selected;

    static void input() {
        N = scan.nextInt();
        food = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            food[i][0] = scan.nextInt(); // 신맛
            food[i][1] = scan.nextInt(); // 쓴맛
        }
        min = Integer.MAX_VALUE;
        selected = new int[N + 1];
    }

    static void rec_func(int k, int cnt) {
        if (k == cnt + 1) {
            int sum1 = 1, sum2 = 0;
            for (int i = 1; i <= cnt; i++) {
                sum1 *= food[selected[i]][0];
                sum2 += food[selected[i]][1];
            }
            min = Math.min(min, Math.abs(sum1 - sum2));
        } else {
            for (int cand = selected[k-1] + 1; cand <= N; cand++) {
                selected[k] = cand;
                rec_func(k + 1, cnt);
            }
        }
    }

    static void pro() {
        for (int i = 1; i <= N; i++) rec_func(1, i);
        System.out.println(min);
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