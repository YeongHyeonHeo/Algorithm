import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static String str;
    static char[] ch;

    static void input() {
        str = scan.nextLine();
        ch = new char[str.length()];
        for (int i = 0; i < str.length(); i++) ch[i] = str.charAt(i);
    }

    static void pro() {
        for (int i = 0; i < ch.length-1; i++) {
            for (int j = i+1; j < ch.length; j++) {
                if (ch[i] != '-' && ch[i] == ch[j]) {
                    ch[i] = '-';
                    ch[j] = '-';
                    break;
                }
            }
        }
        Arrays.sort(ch);
        boolean flag = true;
        for (char c : ch) {
            if (c != '-') {
                sb.append(c);
                flag = false;
            }
        }
        if (flag) sb.append("Good\n");
        else sb.append('\n');
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