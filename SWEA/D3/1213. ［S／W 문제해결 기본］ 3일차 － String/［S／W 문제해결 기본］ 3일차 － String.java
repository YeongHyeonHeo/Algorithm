import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static String find, str;

    static void input() {
        find = scan.nextLine();
        str = scan.nextLine();
    }

    static void pro() {
        int ans = 0;
        for (int i = 0; i <= str.length()-find.length(); i++) {
            String sub = str.substring(i, i+find.length());
            if (find.equals(sub)) ans++;
        }
        sb.append(ans).append('\n');
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            int T = scan.nextInt();
            sb.append('#').append(T).append(' ');
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