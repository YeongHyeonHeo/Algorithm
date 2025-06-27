import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();

    static int N;

    static void input() {
        N = scan.nextInt();
    }

    static void pro() {
        for (int i = 1; i <= N; i++) {
            int n = i;
            String num = Integer.toString(i);
            for (int j = 0; j < num.length(); j++) n += num.charAt(j) - '0';
            if (n == N) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
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