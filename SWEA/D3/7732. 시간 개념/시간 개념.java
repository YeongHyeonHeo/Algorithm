import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static String str, str2;
    static int H, M, S, H2, M2, S2;

    static void input() {
        str = scan.nextLine();
        str2 = scan.nextLine();
        String[] s = str.split(":");
        String[] s2 = str2.split(":");
        H = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        S = Integer.parseInt(s[2]);
        H2 = Integer.parseInt(s2[0]);
        M2 = Integer.parseInt(s2[1]);
        S2 = Integer.parseInt(s2[2]);
    }

    static void pro() {
        int now = H * 3600 + M * 60 + S;
        int rec = H2 * 3600 + M2 * 60 + S2;

        int a;
        if (now <= rec) a = rec - now;
        else a = (86400 - now) + rec;

        int ansH = a / 3600;
        int ansM = (a % 3600) / 60;
        int ansS = (a % 3600) % 60;

        if (ansH < 10) sb.append('0').append(ansH).append(':');
        else sb.append(ansH).append(':');
        if (ansM < 10) sb.append('0').append(ansM).append(':');
        else sb.append(ansM).append(':');
        if (ansS < 10) sb.append('0').append(ansS).append('\n');
        else sb.append(ansS).append('\n');
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