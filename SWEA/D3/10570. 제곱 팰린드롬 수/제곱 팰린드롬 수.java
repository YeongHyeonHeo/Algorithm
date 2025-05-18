import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int A, B, ans;

    static void input() {
        A = scan.nextInt();
        B = scan.nextInt();
        ans = 0;
    }

    static boolean isInt(double d) {
        return d - (int) d == 0;
    }

    static void isP(int num, double num2) {
        String str = Integer.toString(num);
        String str2 = Integer.toString((int)num2);
        boolean flag = true, flag2 = true;
        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length()-i-1)) {
                flag = false;
                break;
            }
        }
        for (int i = 0; i < str2.length()/2; i++) {
            if (str2.charAt(i) != str2.charAt(str2.length()-i-1)) {
                flag2 = false;
                break;
            }
        }
        if (flag && flag2) ans++;
    }

    static void pro() {
        for (int i = A; i <= B; i++) {
            if (!isInt(Math.sqrt(i))) continue;
            isP(i, Math.sqrt(i));
        }
        sb.append(ans).append('\n');
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