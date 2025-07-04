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
        int ans = 0;
        for (int i = 0; i < L; i++) {
            double n = (str.charAt(i) - 'a' + 1) * Math.pow(31, i);
            ans += (int)n % 1234567891;
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