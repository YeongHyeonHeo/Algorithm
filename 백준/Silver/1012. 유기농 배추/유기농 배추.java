import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int T, M, N, K, cnt;
    static int[][] a;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] visit;

    static void input() {
        M = scan.nextInt();
        N = scan.nextInt();
        K = scan.nextInt();
        a = new int[N][M];
        for (int i = 0; i < K; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            a[y][x] = 1;
        }
        visit = new boolean[N][M];
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (a[nx][ny] == 0) continue;
            if (visit[nx][ny]) continue;
            dfs(nx, ny);
        }
    }

    static void pro() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visit[i][j] && a[i][j] == 1) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        cnt = 0;
    }

    public static void main(String[] args) {
        T = scan.nextInt();
        for (int i = 0; i < T; i++) {
            input();
            pro();
        }
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