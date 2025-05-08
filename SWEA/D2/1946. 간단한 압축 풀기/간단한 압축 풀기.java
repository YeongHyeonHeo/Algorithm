import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static String[] str;
    static int[] num;

    static void input() {
        N = scan.nextInt();
        str = new String[N];
        num = new int[N];
        for (int i = 0; i < N; i++) {
            str[i] = scan.next();
            num[i] = scan.nextInt();
        }
    }

    static void pro() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < num[i]; j++) {
                cnt++;
                sb.append(str[i]);
                if (cnt == 10) {
                    if (i == N-1 && j == num[i]-1) continue;
                    sb.append('\n');
                    cnt = 0;
                }
            }
        }
        sb.append('\n');
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append('\n');
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