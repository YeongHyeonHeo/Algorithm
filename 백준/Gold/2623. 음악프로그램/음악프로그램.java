import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[] indeg;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        adj = new ArrayList[N + 1];
        indeg = new int[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int cnt = scan.nextInt(), x = scan.nextInt(), y;
            for (int j = 2; j <= cnt; j++) {
                y = scan.nextInt();
                adj[x].add(y);
                indeg[y]++;
                x = y;
            }
        }
    }

    static void pro() {
        Queue<Integer> que = new LinkedList<>();
        Queue<Integer> res = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) que.add(i);
        }

        while (!que.isEmpty()) {
            int x = que.poll();
            res.add(x);
            for (int y : adj[x]) {
                indeg[y]--;
                if (indeg[y] == 0) que.add(y);
            }
        }

        if (res.size() < N) sb.append(0);
        else {
            for (int i : res) sb.append(i).append('\n');
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