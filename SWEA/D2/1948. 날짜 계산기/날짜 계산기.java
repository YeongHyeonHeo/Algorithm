import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int m1, d1, m2, d2;

    static void input() {
        m1 = scan.nextInt();
        d1 = scan.nextInt();
        m2 = scan.nextInt();
        d2 = scan.nextInt();
    }

    static int day(int month) {
        if (month == 2) return 28;
        else if (month == 4 || month == 6 || month == 9 || month == 11) return 30;
        else return 31;
    }

    static void pro() {
        int sum = 0;
        if (m1 == m2) sum += d2 - d1;
        else {
            sum += day(m1) - d1 + d2;
            for (int i = m1+1; i <= m2-1; i++) sum += day(i);
        }
        sb.append(sum+1).append('\n');
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