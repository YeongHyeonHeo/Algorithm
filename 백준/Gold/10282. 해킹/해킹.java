import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Info {
        int idx, dist;
        Info(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    static int n, d, c;
    static ArrayList<Edge>[] edges;
    static int[] dist;

    static void input() {
        n = scan.nextInt();
        d = scan.nextInt();
        c = scan.nextInt();
        edges = new ArrayList[n + 1];
        dist = new int[n + 1];
        for (int i = 1; i <= n; i++) edges[i] = new ArrayList<>();
        for (int i = 0; i < d; i++) {
            int to = scan.nextInt();
            int from = scan.nextInt();
            int weight = scan.nextInt();
            edges[from].add(new Edge(to, weight));
        }
    }

    static void dijkstra(int start) {
        for (int i = 1; i <= n; i++) dist[i] = Integer.MAX_VALUE;
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        pq.add(new Info(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Info info = pq.poll();
            if (dist[info.idx] != info.dist) continue;
            for (Edge e : edges[info.idx]) {
                if (dist[info.idx] + e.weight >= dist[e.to]) continue;
                dist[e.to] = dist[info.idx] + e.weight;
                pq.add(new Info(e.to, dist[e.to]));
            }
        }
    }

    static void pro() {
        dijkstra(c);
        int cnt = 0, time = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                cnt++;
                time = Math.max(time, dist[i]);
            }
        }
        sb.append(cnt).append(' ').append(time).append('\n');
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        while (T-- > 0) {
            input();
            pro();
        }
        System.out.print(sb);
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