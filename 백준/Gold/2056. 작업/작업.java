import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, ans;
    static ArrayList<Integer>[] adj;
    static int[] indeg, T, T_done;

    static void input() {
        N = scan.nextInt();
        adj = new ArrayList[N + 1];
        indeg = new int[N + 1];
        T = new int[N + 1];
        T_done = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
            T[i] = scan.nextInt();
            int k = scan.nextInt();
            for (int j = 1; j <= k; j++) {
                int x = scan.nextInt();
                adj[x].add(i);
                indeg[i]++;
            }
        }
    }

    static void pro() {
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                que.add(i);
                T_done[i] = T[i];
                ans = Math.max(ans, T_done[i]);
            }
        }

        while (!que.isEmpty()) {
            int x = que.poll();
            for (int y : adj[x]) {
                indeg[y]--;
                if (indeg[y] == 0) que.add(y);
                T_done[y] = Math.max(T_done[y], T_done[x] + T[y]);
                ans = Math.max(ans, T_done[y]);
            }
        }
        System.out.println(ans);
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