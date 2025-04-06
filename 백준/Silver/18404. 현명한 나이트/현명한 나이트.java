import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, X, Y;
    static int[][] dist;
    static int[][] dir = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
            {1, -2}, {1, 2}, {2, -1}, {2, 1}};

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        X = scan.nextInt();
        Y = scan.nextInt();
        dist = new int[N + 1][N + 1];
    }

    static void bfs(int x, int y) {
        for (int i = 1; i <= N; i++) for (int j = 1; j <= N; j++) dist[i][j] = -1;
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x); Q.add(y);
        dist[x][y] = 0;

        while (!Q.isEmpty()) {
            x = Q.poll(); y = Q.poll();
            for (int k = 0; k < 8; k++) {
                int nx = x + dir[k][0], ny = y + dir[k][1];
                if (nx <= 0 || ny <= 0 || nx > N || ny > N) continue;
                if (dist[nx][ny] != -1) continue;
                Q.add(nx); Q.add(ny);
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
    }

    static void pro() {
        bfs(X, Y);
        for (int i = 0; i < M; i++) {
            int A = scan.nextInt(), B = scan.nextInt();
            sb.append(dist[A][B]).append(' ');
        }
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