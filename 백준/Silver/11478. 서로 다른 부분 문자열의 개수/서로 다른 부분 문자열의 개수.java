import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();

    static String S;
    static HashSet<String> set = new HashSet<>();

    static void input() {
        S = scan.next();
    }

    static void pro() {
        for (int i = 0; i < S.length(); i++) {
            for (int j = i+1; j <= S.length(); j++)
                set.add(S.substring(i, j));
        }
        System.out.println(set.size());
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
    }
}