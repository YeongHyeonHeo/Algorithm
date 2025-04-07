import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int M, N, H;
    static int[][][] A, dist;
    static int[][] dir = {{0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1},
            {1, 0, 0}, {-1, 0, 0}};

    static void input() {
        M = scan.nextInt();
        N = scan.nextInt();
        H = scan.nextInt();
        A = new int[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) A[i][j][k] = scan.nextInt();
            }
        }
        dist = new int[H][N][M];
    }

    static void bfs() {
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    dist[i][j][k] = -1;
                    if (A[i][j][k] == 1) {
                        Q.add(i);
                        Q.add(j);
                        Q.add(k);
                        dist[i][j][k] = 0;
                    }
                }
            }
        }

        while (!Q.isEmpty()) {
            int h = Q.poll(), x = Q.poll(), y = Q.poll();
            for (int k = 0; k < 6; k++) {
                int nh = h + dir[k][0], nx = x + dir[k][1], ny = y + dir[k][2];
                if (nh < 0 || nx < 0 || ny < 0 || nh >= H || nx >= N || ny >= M) continue;
                if (A[nh][nx][ny] != 0) continue;
                if (dist[nh][nx][ny] != -1) continue;
                Q.add(nh);
                Q.add(nx);
                Q.add(ny);
                dist[nh][nx][ny] = dist[h][x][y] + 1;
            }
        }

    }

    static void pro() {
        int ans = -1;
        bfs();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (A[i][j][k] == 0 && dist[i][j][k] == -1) {
                        System.out.println(-1);
                        return;
                    }
                    ans = Math.max(ans, dist[i][j][k]);
                }
            }
        }
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