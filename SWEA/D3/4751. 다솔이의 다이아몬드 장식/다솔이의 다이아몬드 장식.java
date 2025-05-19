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
        for (int i = 0; i < str.length(); i++) sb.append("..#.");
        sb.append('.').append('\n');
        for (int i = 0; i < str.length(); i++) sb.append(".#.#");
        sb.append('.').append('\n');
        for (int i = 0; i < str.length(); i++) sb.append("#.").append(str.charAt(i)).append('.');
        sb.append('#').append('\n');
        for (int i = 0; i < str.length(); i++) sb.append(".#.#");
        sb.append('.').append('\n');
        for (int i = 0; i < str.length(); i++) sb.append("..#.");
        sb.append('.').append('\n');
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        while (T-- > 0) {
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