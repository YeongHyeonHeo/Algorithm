import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int[] A, B, selected, used;
    static boolean[] has;
    static int win, lose;

    static void input() {
        A = new int[10];
        B = new int[10];
        selected = new int[10];
        used = new int[10];
        has = new boolean[19];
        for (int i = 1; i <= 9; i++) {
            A[i] = scan.nextInt();
            has[A[i]] = true;
        }
        win = 0;
        lose = 0;
    }

    static void rec_func(int k) {
        if (k == 10) {
            int Asum = 0, Bsum = 0;
            for (int i = 1; i <= 9; i++) {
                if (A[i] > B[selected[i]]) Asum += A[i] + B[selected[i]];
                else Bsum += A[i] + B[selected[i]];
            }
            if (Asum > Bsum) win++;
            else if (Asum < Bsum) lose++;
        } else {
            for (int cand = 1; cand <= 9; cand++) {
                if (used[cand] == 1) continue;
                selected[k] = cand;     used[cand] = 1;
                rec_func(k + 1);
                used[cand] = 0;
            }
        }
    }

    static void pro() {
        int k = 1;
        for (int i = 1; i <= 18; i++) {
            if (!has[i]) {
                B[k] = i;
                k++;
            }
        }
        rec_func(1);
        sb.append(win).append(' ').append(lose).append('\n');
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(' ');
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