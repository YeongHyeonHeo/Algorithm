import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, r, c, ans;

    static void input() {
        N = scan.nextInt();
        r = scan.nextInt();
        c = scan.nextInt();
    }

    // 사분면 탐색
    static void rec_func(int R, int C, int size) {
        if (size == 1) {
            sb.append(ans);
            return;
        }
        int newSize = size / 2;
        if (r < R + newSize && c < C + newSize) rec_func(R, C, newSize);
        else if (r < R + newSize && C + newSize <= c) {
            ans += (size * size) / 4;
            rec_func(R, C + newSize, newSize);
        } else if (R + newSize <= r && c < C + newSize) {
            ans += ((size * size) / 4) * 2;
            rec_func(R + newSize, C, newSize);
        } else if (R + newSize <= r && C + newSize <= c) {
            ans += ((size * size) / 4) * 3;
            rec_func(R + newSize, C + newSize, newSize);
        }
    }

    static void pro() {
        rec_func(0, 0, (int)Math.pow(2, N));
        System.out.print(sb);
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