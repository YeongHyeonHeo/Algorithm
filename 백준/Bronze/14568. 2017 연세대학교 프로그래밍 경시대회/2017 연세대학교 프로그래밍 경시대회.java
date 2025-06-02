import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();

    static int N;

    static void input() {
        N = scan.nextInt();
    }

    static void pro() {
        int cnt = 0;
        for (int A = 1; A <= N; A++) {
            for (int B = 1; B <= N; B++) {
                for (int C = 1; C <= N; C++) {
                    if (A + B + C != N) continue;
                    if (!(C >= B+2)) continue;
                    if (A % 2 == 1) continue;
                    cnt++;
                }
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
    }
}