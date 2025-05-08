import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int A, B, N, cnt;

    static void input() {
        A = scan.nextInt();
        B = scan.nextInt();
        N = scan.nextInt();
        cnt = 0;
    }

    static void dfs(int x, int y) {
        int sum = x + y;
        cnt++;
        if (sum > N) return;
        else dfs(sum, x);
    }

    static void pro() {
        if (A > B) dfs(A, B);
        else dfs(B, A);
        sb.append(cnt).append('\n');
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        while (T-- > 0) {
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