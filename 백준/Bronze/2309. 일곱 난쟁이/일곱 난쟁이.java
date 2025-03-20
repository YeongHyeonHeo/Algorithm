import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        arr = new int[10];
        for (int i = 1; i <= 9; i++) arr[i] = scan.nextInt();
        selected = new int[8];
        height = new int[8];
        ans = new int[8];
    }

    static int[] arr, selected, height, ans;
    static int hap = 0;

    static void rec_func(int k, int[] arr, int hap) {
        if (k == 8) {
            if (hap == 100) {
                for (int i = 1; i <= 7; i++) ans[i] = height[i];
            }
        } else {
            for (int cand = selected[k-1] + 1; cand <= 9; cand++) {
                selected[k] = cand;
                height[k] = arr[cand];
                rec_func(k + 1, arr, hap + height[k]);
                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        Arrays.sort(arr);
        rec_func(1, arr, hap);
        for (int i = 1; i <= 7; i++) sb.append(ans[i]).append('\n');
        System.out.println(sb.toString());
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
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