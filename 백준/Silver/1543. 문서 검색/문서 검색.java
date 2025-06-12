import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static String word, find;

    static void input() {
        word = scan.nextLine();
        find = scan.nextLine();
    }

    static void pro() {
        int cnt = 0;
        for (int i = 0; i < word.length() - find.length() + 1; i++) {
            boolean flag = true;
            for (int j = 0; j < find.length(); j++) {
                if (word.charAt(i + j) != find.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                cnt++;
                i += find.length() - 1;
            }
        }
        System.out.println(cnt);
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