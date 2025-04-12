import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, home, chicken, ans;
    static int[][] A, home_arr, chick_arr;
    static int[] selected;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N + 1][N + 1];
        home_arr = new int[2*N + 1][2];
        chick_arr = new int[14][2];
        selected = new int[M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                A[i][j] = scan.nextInt();
            }
        }
        ans = Integer.MAX_VALUE;
    }

    static void chick_dist() {
        int dist_sum = 0;
        for (int i = 1; i <= home; i++) {
            int home_min = Integer.MAX_VALUE;
            for (int j = 1; j <= M; j++) {
                int chic = selected[j];
                int dist = Math.abs(home_arr[i][0] - chick_arr[chic][0]) + Math.abs(home_arr[i][1] - chick_arr[chic][1]);
                home_min = Math.min(home_min, dist);
            }
            dist_sum += home_min;
        }
        ans = Math.min(ans, dist_sum);
    }

    static void rec_func(int k) {
        if (k == M + 1) {
            chick_dist();
        } else {
            for (int cand = selected[k-1] + 1; cand <= chicken; cand++) {
                selected[k] = cand;
                rec_func(k + 1);
            }
        }
    }

    static void pro() {
        // 집, 치킨집 모으기
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (A[i][j] == 1) {
                    home++;
                    home_arr[home][0] = i;
                    home_arr[home][1] = j;
                }
                if (A[i][j] == 2) {
                    chicken++;
                    chick_arr[chicken][0] = i;
                    chick_arr[chicken][1] = j;
                }
            }
        }

        // M 개 치킨집 고르기
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}