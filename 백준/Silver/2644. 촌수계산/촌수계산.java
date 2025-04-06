import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n, m, x, y;
    static int[] dist;
    static ArrayList<Integer>[] adj;

    static void input() {
        n = scan.nextInt();
        x = scan.nextInt();
        y = scan.nextInt();
        m = scan.nextInt();
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int a = scan.nextInt(), b = scan.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }
        dist = new int[n + 1];
    }

    static void bfs(int start) {
        for (int i = 1; i <= n; i++) dist[i] = -1;
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        dist[start] = 0;

        while (!que.isEmpty()) {
            int x = que.poll();
            for (int y : adj[x]) {
                if (dist[y] != -1) continue;
                que.add(y);
                dist[y] = dist[x] + 1;
            }
        }
    }

    static void pro() {
        bfs(x);
        System.out.println(dist[y]);
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