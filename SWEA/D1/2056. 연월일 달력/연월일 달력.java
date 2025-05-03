import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static String str;

    static void input() {
        str = scan.nextLine();
    }

    static void pro() {
        int month = Integer.parseInt(str.substring(4,6));
        int day = Integer.parseInt(str.substring(6,8));

        if (1 > month || month > 12) {
            sb.append(-1).append('\n');
            return;
        }
        else {
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                if (1 > day || day > 31) {
                    sb.append(-1).append('\n');
                    return;
                }
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                if (1 > day || day > 30) {
                    sb.append(-1).append('\n');
                    return;
                }
            } else {
                if (1 > day || day > 28) {
                    sb.append(-1).append('\n');
                    return;
                }
            }
        }

        sb.append(str, 0, 4).append('/').append(str, 4, 6).append('/').append(str, 6, 8).append('\n');
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(' ');
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