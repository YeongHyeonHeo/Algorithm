import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int[] selected, A, sumArr;
    static int idx;

    static void input() {
        selected = new int[4];
        A = new int[8];
        sumArr = new int[35];
        for (int i = 1; i <= 7; i++) A[i] = scan.nextInt();
        idx = 0;
    }

    static void rec_func(int k) {
        if (k == 4) {
            int sum = 0;
            for (int i = 1; i <= 3; i++) sum += A[selected[i]];
            sumArr[idx] = sum;
            idx++;
        } else {
            for (int cand = selected[k-1]+1; cand <= 7; cand++) {
                selected[k] = cand;
                rec_func(k+1);
            }
        }
    }

    static void pro() {
        rec_func(1);
        Arrays.sort(sumArr);
        int n = 1;
        int min = sumArr[34];
        for (int i = 33; i >= 0; i--) {
            if (min > sumArr[i]) {
                min = sumArr[i];
                n++;
            }
            if (n == 5) break;
        }
        sb.append(min).append('\n');
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