import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, K, X;
    static ArrayList<Integer>[] adj;
    static int[] dist;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        K = scan.nextInt();
        X = scan.nextInt();
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x].add(y);
        }
        dist = new int[N + 1];
    }

    static void bfs(int start) {
        for (int i = 1; i <= N; i++) dist[i] = -1;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int x = q.poll();
            for (int y : adj[x]) {
                if (dist[y] != -1) continue;
                q.add(y);
                dist[y] = dist[x] + 1;
            }
        }
    }

    static void pro() {
        bfs(X);
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                sb.append(i).append('\n');
                cnt++;
            }
        }
        if (cnt == 0) sb.append("-1\n");
        System.out.print(sb);
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
    }
}