import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Info {
        int x, k;
        Info(int x, int k) {
            this.x = x;
            this.k = k;
        }
    }

    static int N, M;
    static int[] indeg;
    static int[][] cnt;
    static ArrayList<Info>[] adj;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        adj = new ArrayList[N + 1];
        indeg = new int[N + 1];
        cnt = new int[N + 1][N + 1];
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
            for (Info y : adj[x]) {
                indeg[y.x]--;
                if (indeg[y.x] == 0) que.add(y.x);
                for (int i = 1; i <= N; i++) {
                    cnt[y.x][i] += cnt[x][i] * y.k;
                }
            }
        }
        for (int i = 1; i <= N; i++)
            if (cnt[N][i] != 0) System.out.println(i + " " + cnt[N][i]);
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