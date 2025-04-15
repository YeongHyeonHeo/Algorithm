import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Info {
        int to, cnt;
        Info(int to, int cnt) {
            this.to = to;
            this.cnt = cnt;
        }
    }

    static int N, M;
    static int[] indeg;
    static int[][] cnt;
    static ArrayList<Info>[] adj;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        indeg = new int[N + 1];
        cnt = new int[N + 1][N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            int x = scan.nextInt(), y = scan.nextInt(), k = scan.nextInt();
            adj[y].add(new Info(x, k));
            indeg[x]++;
        }
    }

    static void pro() {
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                que.add(i);
                cnt[i][i] = 1;
            }
        }

        while (!que.isEmpty()) {
            int x = que.poll();
            for (Info info : adj[x]) {
                int to = info.to, cnt_i = info.cnt;
                indeg[to]--;
                if (indeg[to] == 0) que.add(to);
                for (int i = 1; i <= N; i++) {
                    cnt[to][i] += cnt[x][i] * cnt_i;
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if (cnt[N][i] != 0) sb.append(i).append(' ').append(cnt[N][i]).append('\n');
        }
        System.out.println(sb);
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