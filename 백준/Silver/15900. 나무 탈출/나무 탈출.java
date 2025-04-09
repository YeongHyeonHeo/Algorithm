import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, sum_leaf_depth;
    static ArrayList<Integer>[] a;

    static void input() {
        N = scan.nextInt();
        a = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) a[i] = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            int x = scan.nextInt(), y = scan.nextInt();
            a[x].add(y);
            a[y].add(x);
        }
    }

    // 트리를 순회하면서 sum_leaf_depth 계산
    static void dfs(int x, int prev, int depth) {
        if (a[x].size() == 1) sum_leaf_depth += depth;
        for (int y : a[x]) {
            if (y == prev) continue;
            dfs(y, x, depth + 1);
        }
    }

    static void pro() {
        dfs(1, -1, 0);
        if (sum_leaf_depth % 2 == 1) System.out.println("Yes");
        else System.out.println("No");
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