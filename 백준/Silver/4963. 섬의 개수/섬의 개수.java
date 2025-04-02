import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int w, h;
    static String[] A;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1},
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    static void input() {
        w = scan.nextInt();
        h = scan.nextInt();
        A = new String[h];
        for (int i = 0; i < h; i++) {
            String a = scan.nextLine();
            A[i] = a.replaceAll(" ", "");
        }
        visit = new boolean[h][w];
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;
        for (int k = 0; k < 8; k++) {
            int nx = x + dir[k][0], ny = y + dir[k][1];
            if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
            if (A[nx].charAt(ny) == '0') continue;
            if (visit[nx][ny]) continue;
            dfs(nx, ny);
        }
    }

    static void pro() {
        int ans = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!visit[i][j] && A[i].charAt(j) == '1') {
                    dfs(i, j);
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        while (true) {
            input();
            if (w == 0) break;
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