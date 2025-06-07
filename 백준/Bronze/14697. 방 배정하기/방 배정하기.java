import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();

    static int A, B, C, N;
    static boolean cnt;

    static void input() {
        A = scan.nextInt();
        B = scan.nextInt();
        C = scan.nextInt();
        N = scan.nextInt();
    }

    static void pro() {
        for (int i = 0; i <= 300; i++) {
            for (int j = 0; j <= 300; j++) {
                for (int k = 0; k <= 300; k++) {
                    if (A*i + B*j + C*k == N) {
                        cnt = true;
                        break;
                    }
                }
            }
        }
        if (cnt) System.out.println(1);
        else System.out.println(0);
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