import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();

    static String str;
    static int[] cnt;

    static void input() {
        str = scan.nextLine().toUpperCase();
        cnt = new int[26];
    }

    static void pro() {
        for (int i = 0; i < str.length(); i++) cnt[str.charAt(i) - 'A']++;
        int max = 0;
        char ans = '?';
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > max) {
                max = cnt[i];
                ans = (char)('A' + i);
            } else if (cnt[i] == max) ans = '?';
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
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