import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int[] height, selected;
    static boolean flag;

    static void input() {
        height = new int[10];
        for (int i = 1; i <= 9; i++) height[i] = scan.nextInt();
        selected = new int[8];
    }

    static void rec_func(int k, int sum) {
        if (flag) return;
        if (k == 8) {
            if (sum == 100) {
                for (int i = 1; i <= 7; i++) sb.append(height[selected[i]]).append('\n');
                flag = true;
            }
        } else {
            for (int cand = selected[k-1] + 1; cand <= 9; cand++) {
                selected[k] = cand;
                rec_func(k + 1, sum + height[cand]);
            }
        }
    }

    static void pro() {
        Arrays.sort(height, 1, 10);
        rec_func(1, 0);
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