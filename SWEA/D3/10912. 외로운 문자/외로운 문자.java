import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static String str;
    static int[] alp;

    static void input() {
        str = scan.nextLine();
        alp = new int[26];
        for (int i = 0; i < str.length(); i++) alp[str.charAt(i)-'a']++;
    }

    static void pro() {
        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            if (alp[i] != 0 && alp[i] % 2 == 1) {
                sb.append((char)(i+'a'));
                cnt++;
            }
        }
        if (cnt > 0) sb.append("\n");
        else sb.append("Good\n");
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