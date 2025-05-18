import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] cnt;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        cnt = new int[N];
    }

    static void pro() {
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < M; j++) {
                if (scan.nextInt() == 1) count++;
            }
            cnt[i] = count;
        }
        Arrays.sort(cnt);
        int max = cnt[N-1];
        int ans = 0;
        for (int i = N-1; i >= 0; i--) {
            if (max == cnt[i]) ans++;
            else break;
        }
        sb.append(ans).append(' ').append(max).append('\n');
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