import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int[] ans;
    static ArrayList<Integer>[] child;

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();
        ans = new int[n + 1];
        child = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            child[i] = new ArrayList<>();
            int par = scan.nextInt();
            if (par == -1) continue;
            child[par].add(i);
        }
        for (int i = 1; i <= m; i++) {
            int x = scan.nextInt(), w = scan.nextInt();
            ans[x] += w;
        }
    }

    static void DFS(int x) {
        for (int y : child[x]) {
            ans[y] += ans[x];
            DFS(y);
        }
    }

    static void pro() {
        DFS(1);
        for (int i = 1; i <= n; i++) sb.append(ans[i]).append(' ');
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