import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, chicken, home, erase_cnt, ans;
    static int[][] A, chic_arr, home_arr;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N + 1][N + 1];
        chic_arr = new int[14][2];
        home_arr = new int[2*N + 1][2];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) A[i][j] = scan.nextInt();
        }
        ans = Integer.MAX_VALUE;
    }

    static void chick_dist() {
        int dist_sum = 0;
        for (int i = 1; i <= home; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= chicken; j++) {
                if (A[chic_arr[j][0]][chic_arr[j][1]] == 2) {
                    int dist = Math.abs(home_arr[i][0] - chic_arr[j][0]) + Math.abs(home_arr[i][1] - chic_arr[j][1]);
                    min = Math.min(min, dist);
                }
            }
            dist_sum += min;
        }
        ans = Math.min(ans, dist_sum);
    }

    static void dfs(int idx, int cnt) {
        if (cnt == erase_cnt) {
            // 도시의 치킨거리 계산
            chick_dist();
            return;
        }
        if (idx > chicken) return;

        A[chic_arr[idx][0]][chic_arr[idx][1]] = 0;
        dfs(idx + 1, cnt + 1);

        A[chic_arr[idx][0]][chic_arr[idx][1]] = 2;
        dfs(idx + 1, cnt);
    }

    static void pro() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                // 치킨집 위치 모으기
                if (A[i][j] == 2) {
                    chicken++;
                    chic_arr[chicken][0] = i;
                    chic_arr[chicken][1] = j;
                }

                // 집 위치 모으기
                if (A[i][j] == 1) {
                    home++;
                    home_arr[home][0] = i;
                    home_arr[home][1] = j;
                }
            }
        }
        erase_cnt = chicken - M;
        // 치킨집 제거
        dfs(1, 0);
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