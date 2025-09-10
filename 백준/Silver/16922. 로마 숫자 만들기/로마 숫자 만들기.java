import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, ans;
    static int[] nums = {1, 5, 10, 50};
    static boolean[] visited;

    static void input() {
        N = scan.nextInt();
        visited = new boolean[1001];
    }

    static void dfs(int depth, int start, int sum) {
        if (depth == N) {
            if (!visited[sum]) {
                visited[sum] = true;
                ans++;
            }
            return;
        }

        for (int i = start; i < 4; i++)
            dfs(depth + 1, i, sum + nums[i]);
    }

    static void pro() {
        dfs(0, 0, 0);
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
    }
}