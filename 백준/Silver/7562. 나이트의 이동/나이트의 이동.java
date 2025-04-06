import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int T, N, X, Y, wantX, wantY;
    static int[][] dist;
    static int[][] dir = {{-2, -1}, {-1, -2}, {2, 1}, {1, 2},
            {2, -1}, {1, -2}, {-2, 1}, {-1, 2}};

    static void input() {
        N = scan.nextInt();
        X = scan.nextInt();
        Y = scan.nextInt();
        wantX = scan.nextInt();
        wantY = scan.nextInt();
        dist = new int[N][N];
    }

    static void bfs(int x, int y) {
        for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) dist[i][j] = -1;
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x); Q.add(y);
        dist[x][y] = 0;

        while (!Q.isEmpty()) {
            x = Q.poll(); y = Q.poll();
            for (int k = 0; k < 8; k++) {
                int nx = x + dir[k][0], ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (dist[nx][ny] != -1) continue;
                Q.add(nx); Q.add(ny);
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
    }

    static void pro() {
        bfs(X, Y);
        System.out.println(dist[wantX][wantY]);
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