import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static ArrayList<Integer>[] adj;
    static int[] dist;

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
        dist = new int[n + 1];
    }

    static void bfs() {
        for (int i = 1; i <= n; i++) dist[i] = -1;
        Queue<Integer> Q = new LinkedList<>();
        Q.add(1);
        dist[1] = 0;

        while (!Q.isEmpty()) {
            int x = Q.poll();
            for (int y : adj[x]) {
                if (dist[y] != -1) continue;
                Q.add(y);
                dist[y] = dist[x] + 1;
            }
        }
    }

    static void pro() {
        bfs();
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            if (1 <= dist[i] && dist[i] <= 2) ans++;
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