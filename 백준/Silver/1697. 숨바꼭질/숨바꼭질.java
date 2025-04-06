import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K;
    static int[] dist;
    static int[] dir = {1, -1, 2};

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        dist = new int[100000 + 1];
    }

    static void bfs(int start) {
        for (int i = 0; i <= 100000; i++) dist[i] = -1;
        Queue<Integer> Q = new LinkedList<>();
        Q.add(start);
        dist[start] = 0;

        while (!Q.isEmpty()) {
            int x = Q.poll();
            for (int k = 0; k < 3; k++) {
                int nx;
                if (dir[k] == 2) nx = x * dir[k];
                else nx = x + dir[k];
                if (nx < 0 || nx > 100000) continue;
                if (dist[nx] != -1) continue;
                Q.add(nx);
                dist[nx] = dist[x] + 1;
            }
        }
    }

    static void pro() {
        bfs(N);
        System.out.println(dist[K]);
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