import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        A = new int[7];
        for (int i = 0; i < 7; i++) A[i] = scan.nextInt();
    }

    static void pro() {
        int res = Integer.MAX_VALUE;
        for (int idx = 0; idx < 7; idx++) {
            int cnt = 0, ans = 0;
            boolean flag = false;
            while (true) {
                for (int i = idx; i < 7; i++) {
                    if (A[i] == 1) cnt++;
                    ans++;
                    if (cnt == N) {
                        flag = true;
                        break;
                    }
                }
                if (flag) break;
                for (int i = 0; i < idx; i++) {
                    if (A[i] == 1) cnt++;
                    ans++;
                    if (cnt == N) {
                        flag = true;
                        break;
                    }
                }
                if (flag) break;
            }
            res = Math.min(res, ans);
        }
        sb.append(res).append('\n');
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(' ');
            input();
            pro();
        }
        System.out.print(sb);
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