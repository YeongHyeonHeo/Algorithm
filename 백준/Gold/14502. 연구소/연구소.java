import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, B, ans, maxAns;
    static int[][] a, blank;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visit;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        a = new int[N + 1][M + 1];
        blank = new int[N * M + 1][2];
        for (int i = 1; i <= N; i++) for (int j = 1; j <= M; j++) a[i][j] = scan.nextInt();
        visit = new boolean[N + 1][M + 1];
    }

    static void dfs2(int x, int y) {
        visit[x][y] = true;
        for (int k = 0; k < 4; k++) {
            int nx = x + dir[k][0], ny = y + dir[k][1];
            if (nx < 0 || ny < 0 || nx > N || ny > M) continue;
            if (a[nx][ny] != 0) continue;
            if (visit[nx][ny]) continue;
            dfs2(nx, ny);
        }
    }

    static void dfs(int idx, int selected_cnt) {
        if (selected_cnt == 3) {
            ans = 0;
            for (int i = 1; i <= N; i++) for (int j = 1; j <= M; j++) visit[i][j] = false;
            for (int i = 1; i <= N; i++) for (int j = 1; j <= M; j++) {
                if (a[i][j] == 2) dfs2(i ,j);
            }
            for (int i = 1; i <= N; i++) for (int j = 1; j <= M; j++) {
                if (!visit[i][j] && a[i][j] == 0) ans++;
            }
            maxAns = Math.max(maxAns, ans);
            return;
        }
        if (idx > B) return;

        a[blank[idx][0]][blank[idx][1]] = 1;
        dfs(idx + 1, selected_cnt + 1);

        a[blank[idx][0]][blank[idx][1]] = 0;
        dfs(idx + 1, selected_cnt);
    }

    static void pro() {
        // 빈칸 수
        for (int i = 1; i <= N; i++) for (int j = 1; j <= M; j++) {
            if (a[i][j] == 0) {
                B++;
                blank[B][0] = i;
                blank[B][1] = j;
            }
        }

        // 벽 세우기
        dfs(1, 0);
        System.out.println(maxAns);
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
            String str =  "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}