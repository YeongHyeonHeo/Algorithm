import java.io.*;
import java.util.*;

public class Main {
    static FastReadr scan = new FastReadr();
    static StringBuilder sb = new StringBuilder();

    static int M, N;
    static int[][] A, dist;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static void input() {
        M = scan.nextInt();
        N = scan.nextInt();
        A = new int[N][M];
        dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) A[i][j] = scan.nextInt();
        }
    }

    static void bfs() {
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dist[i][j] = -1;
                if (A[i][j] == 1) {
                    Q.add(i);
                    Q.add(j);
                    dist[i][j] = 0;
                }
            }
        }

        while (!Q.isEmpty()) {
            int x = Q.poll(), y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0], ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (dist[nx][ny] != -1 || A[nx][ny] == -1) continue;
                Q.add(nx);
                Q.add(ny);
                dist[nx][ny] = dist[x][y] + 1;
            }
        }
    }

    static void pro() {
        bfs();
        int ans = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] == 0 && dist[i][j] == -1) {
                    sb.append(-1);
                    return;
                }
                ans = Math.max(ans, dist[i][j]);
            }
        }
        sb.append(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
        System.out.print(sb);
    }

    static class FastReadr {
        BufferedReader br;
        StringTokenizer st;

        public FastReadr() {
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