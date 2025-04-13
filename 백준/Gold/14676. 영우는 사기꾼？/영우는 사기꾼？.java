import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, K;
    static ArrayList<Integer>[] adj;
    static int[] indeg, cnt, satisfaction;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        K = scan.nextInt();
        adj = new ArrayList[N + 1];
        indeg = new int[N + 1];
        cnt = new int[N + 1];
        satisfaction = new int[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x].add(y);
            indeg[y]++;
        }
    }

    static void pro() {
        boolean abnormal = false;
        while (K > 0) {
            K--;
            int x = scan.nextInt(), y = scan.nextInt();
            if (x == 1) {
                if (satisfaction[y] < indeg[y]) abnormal = true;
                cnt[y]++;
                if (cnt[y] == 1) {
                    for (int i : adj[y]) satisfaction[i]++;
                }
            } else {
                if (cnt[y] == 0) abnormal = true;
                cnt[y]--;
                if (cnt[y] == 0) {
                    for (int i : adj[y]) satisfaction[i]--;
                }
            }
        }
        if (abnormal) System.out.println("Lier!");
        else System.out.println("King-God-Emperor");
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