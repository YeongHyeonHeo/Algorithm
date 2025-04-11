import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K;
    static ArrayList<Integer>[] adj;
    static int[] indeg, time, time_done;

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        adj = new ArrayList[N + 1];
        indeg = new int[N + 1];
        time = new int[N + 1];
        time_done = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
            time[i] = scan.nextInt();
        }
        for (int i = 0; i < K; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x].add(y);
            indeg[y]++;
        }
    }

    static void pro() {
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                que.add(i);
                time_done[i] = time[i];
            }
        }

        while (!que.isEmpty()) {
            int x = que.poll();
            for (int y : adj[x]) {
                indeg[y]--;
                if (indeg[y] == 0) que.add(y);
                time_done[y] = Math.max(time_done[y], time_done[x] + time[y]);
            }
        }

        int W = scan.nextInt();
        System.out.println(time_done[W]);
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        while (T > 0) {
            T--;
            input();
            pro();
        }
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