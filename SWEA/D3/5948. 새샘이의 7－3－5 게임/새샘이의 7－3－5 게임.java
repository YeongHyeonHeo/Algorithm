import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int[] selected, A;
    static ArrayList<Integer> sumArr;

    static void input() {
        selected = new int[4];
        A = new int[8];
        sumArr = new ArrayList<>();
        for (int i = 1; i <= 7; i++) A[i] = scan.nextInt();
    }

    static void rec_func(int k) {
        if (k == 4) {
            int sum = 0;
            boolean isValid = true;
            for (int i = 1; i <= 3; i++) sum += A[selected[i]];
            for (int num : sumArr) {
                if (num == sum) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) sumArr.add(sum);
        } else {
            for (int cand = selected[k-1]+1; cand <= 7; cand++) {
                selected[k] = cand;
                rec_func(k+1);
            }
        }
    }

    static void pro() {
        rec_func(1);
        sumArr.sort(Collections.reverseOrder());
        sb.append(sumArr.get(4)).append('\n');
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