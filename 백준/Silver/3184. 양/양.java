import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int R, C;
    static String[] A;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int o, v;

    static void input() {
        R = scan.nextInt();
        C = scan.nextInt();
        A = new String[R];
        for (int i = 0; i < R; i++) A[i] = scan.nextLine();
        visit = new boolean[R][C];
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;
        if (A[x].charAt(y) == 'o') o++;
        if (A[x].charAt(y) == 'v') v++;
        for (int k = 0; k < 4; k++) {
            int nx = x + dir[k][0], ny = y + dir[k][1];
            if (nx < 0 || ny < 0 || nx > R - 1 || ny > C - 1) continue;
            if (A[nx].charAt(ny) == '#') continue;
            if (visit[nx][ny]) continue;
            dfs(nx, ny);
        }
    }

    static void pro() {
        int ansO = 0, ansV = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visit[i][j] && A[i].charAt(j) != '#') {
                    o = 0; v = 0;
                    dfs(i, j);
                    if (o > v) ansO += o;
                    else ansV += v;
                }
            }
        }
        sb.append(ansO).append(' ').append(ansV);
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