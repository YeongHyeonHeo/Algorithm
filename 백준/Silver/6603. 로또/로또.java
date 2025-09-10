import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int k;
    static int[] arr, selected;

    static void input() {
        arr = new int[k + 1];
        for (int i = 1; i <= k; i++) arr[i] = scan.nextInt();
        selected = new int[7];
    }

    static void rec_func(int n) {
        if (n == 7) {
            for (int i = 1; i <= 6; i++) sb.append(arr[selected[i]]).append(' ');
            sb.append('\n');
        } else {
            for (int cand = selected[n-1] + 1; cand <= k; cand++) {
                selected[n] = cand;
                rec_func(n + 1);
            }
        }
    }

    static void pro() {
        rec_func(1);
        sb.append('\n');
    }

    public static void main(String[] args) {
        while (true) {
            k = scan.nextInt();
            if (k == 0) break;
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
    }
}