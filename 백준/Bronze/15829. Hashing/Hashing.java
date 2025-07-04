import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();

    static int L;
    static String str;

    static void input() {
        L = scan.nextInt();
        str = scan.nextLine();
    }

    static void pro() {
        long ans = 0;
        for (int i = 0; i < L; i++) {
            long n = str.charAt(i) - 'a' + 1;
            if (i >= 1) {
                for (int j = 0; j < i; j++) n = n * 31 % 1234567891;
            }
            ans += n;
            ans %= 1234567891;
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