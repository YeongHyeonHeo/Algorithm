import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, R, cnt;
    static int[] ans;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        R = scan.nextInt();
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
        cnt = 0;
        ans = new int[N + 1];
        visit = new boolean[N + 1];
    }

    static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visit[x] = true;
        ans[x] = ++cnt;

        while (!queue.isEmpty()) {
            x = queue.poll();
            for (int y : adj[x]) {
                if (visit[y]) continue;
                queue.add(y);
                visit[y] = true;
                ans[y] = ++cnt;
            }
        }
    }

    static void pro() {
        for (int i = 1; i <= N; i++) Collections.sort(adj[i], Collections.reverseOrder());
        bfs(R);
        for (int i = 1; i <= N; i++) sb.append(ans[i]).append('\n');
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