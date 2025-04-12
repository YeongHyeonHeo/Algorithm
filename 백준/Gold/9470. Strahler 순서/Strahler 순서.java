import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int T, K, M, P;
    static ArrayList<Integer>[] adj, stra;
    static int[] indeg, strahler;

    static void input() {
        K = scan.nextInt();
        M = scan.nextInt();
        P = scan.nextInt();
        adj = new ArrayList[M + 1];
        stra = new ArrayList[M + 1];
        indeg = new int[M + 1];
        strahler = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            adj[i] = new ArrayList<>();
            stra[i] = new ArrayList<>();
        }
        for (int i = 0; i < P; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x].add(y);
            indeg[y]++;
        }
    }

    static void pro() {
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= M; i++) {
            if (indeg[i] == 0) {
                que.add(i);
                strahler[i] = 1;
            }
        }

        while (!que.isEmpty()) {
            int x = que.poll();
            for (int y : adj[x]) {
                indeg[y]--;
                if (indeg[y] == 0) que.add(y);
                if (strahler[y] != strahler[x]) {
                    strahler[y] = Math.max(strahler[y], strahler[x]);
                } else if (strahler[y] == strahler[x] && stra[y].contains(strahler[x])) {
                    strahler[y]++;
                }
                stra[y].add(strahler[x]);
            }
        }
        sb.append(K).append(' ').append(strahler[M]).append('\n');
    }

    public static void main(String[] args) {
        T = scan.nextInt();
        while (T > 0){
            T--;
            input();
            pro();
        }
        System.out.println(sb);
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