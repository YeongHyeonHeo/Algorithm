import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();

    static int N, M;
    static boolean[] visit; // 방문 체크
    static ArrayList<Integer>[] adj; // 인접한거

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }

    static void dfs(int x) {
        visit[x] = true;
        for (int y : adj[x]) {
            if (visit[y]) continue;
            dfs(y);
        }
    }

    static void pro() {
        visit = new boolean[N + 1];
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    static class FastReader{
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