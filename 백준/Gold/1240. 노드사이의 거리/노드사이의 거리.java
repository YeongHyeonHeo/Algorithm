import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Edge {
        int y, c;
        Edge(int y, int c) {
            this.y = y;
            this.c = c;
        }
    }

    static int N, M;
    static ArrayList<Edge>[] adj;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            int x = scan.nextInt(), y = scan.nextInt(), c = scan.nextInt();
            adj[x].add(new Edge(y, c));
            adj[y].add(new Edge(x, c));
        }
    }

    static void DFS(int x, int par, int goal, int dist) {
        if (x == goal) {
            System.out.println(dist);
            return;
        }
        for (Edge e : adj[x]) {
            if (e.y == par) continue;
            DFS(e.y, x, goal, dist + e.c);
        }
    }

    static void pro() {
        while (M > 0) {
            M--;
            int x = scan.nextInt(), y = scan.nextInt();
            DFS(x, 0, y, 0);
        }
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