import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    // 간선 정보
    // to: 어느 정점을 향하는지, weight: 가중치
    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    // 정점 정보
    // idx: 정점, dist: 현재 정점까지 거리값
    static class Info {
        int idx, dist;
        Info(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    static int V, E, K;
    static ArrayList<Edge>[] edges;
    static int[] dist;

    static void input() {
        V = scan.nextInt();
        E = scan.nextInt();
        K = scan.nextInt();
        edges = new ArrayList[V + 1];
        dist = new int[V + 1]; // 거리 배열
        for (int i = 1; i <= V; i++) edges[i] = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();
            int weight = scan.nextInt();
            // 간선 정보 추가
            edges[from].add(new Edge(to, weight));
        }
    }

    static void dijkstra(int start) {
        // 모든 정점까지에 대한 거리를 무한대로 초기화
        for (int i = 1; i <= V; i++) dist[i] = Integer.MAX_VALUE;

        // 최소 힙 생성
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));

        // 시작점에 대한 정보 추가
        pq.add(new Info(start, 0));
        // 거리 배열 갱신 (시작점 자신은 0)
        dist[start] = 0;

        // 거리 정보들이 모두 소진될 때까지 거리 배열(dist) 갱신을 반복
        while (!pq.isEmpty()) {
            Info info = pq.poll();

            // 꺼낸 정보가 최신 정보랑 다르면, 의미 없이 낡은 정보이므로 폐기
            if (dist[info.idx] != info.dist) continue;

            // 연결된 모든 간선들을 통해 다른 정점들에 대한 정보 갱신
            for (Edge e : edges[info.idx]) {
                if (dist[info.idx] + e.weight >= dist[e.to]) continue;

                // e.to 까지 갈 수 있는 더 짧은 거리를 찾았다면,
                // 이에 대한 정보를 갱신하고 pq에 추가
                dist[e.to] = dist[info.idx] + e.weight;
                pq.add(new Info(e.to, dist[e.to]));
            }
        }
    }

    static void pro() {
        dijkstra(K); // 시작점 K부터 시작
        for (int i = 1; i <= V; i++) {
            // 경로 존재하지 않는 경우
            if (dist[i] == Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(dist[i]).append('\n');
        }
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