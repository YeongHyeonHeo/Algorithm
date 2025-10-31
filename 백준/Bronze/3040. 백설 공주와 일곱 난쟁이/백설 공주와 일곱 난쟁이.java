import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int[] arr, selected, height, ans;
    static int hap;

    static void input() {
        arr = new int[10];
        for (int i = 1; i <= 9; i++) arr[i] = scan.nextInt();
        selected = new int[8];
        height = new int[8];
        ans = new int[8];
    }

    // 9개 중 7개 고르기 (중복X, 순서X)
    static void rec_func(int k, int hap) {
        if (k == 8) {
            if (hap == 100) {
                for (int i = 1; i <= 7; i++) ans[i] = arr[selected[i]];
            }
        } else {
            for (int cand = selected[k-1]+1; cand <= 9; cand++) {
                selected[k] = cand;
                rec_func(k + 1, hap + arr[selected[k]]);
            }
        }
    }

    static void pro() {
        rec_func(1, hap);
        for (int i = 1; i <= 7; i++) sb.append(ans[i]).append('\n');
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