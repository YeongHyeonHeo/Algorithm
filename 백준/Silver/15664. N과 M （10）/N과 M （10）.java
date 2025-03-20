import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        nums = new int[N + 1];
        for (int i = 1; i <= N; i++) nums[i] = scan.nextInt();

        selected = new int[M + 1];
        ans = new int[M + 1];
    }

    static int N, M;
    static int[] nums, selected, ans;

    static void rec_func(int k, int[] nums) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) sb.append(ans[i]).append(' ');
            sb.append('\n');
        } else {
            int last_cand = 0;
            for (int cand = selected[k-1] + 1; cand <= N; cand++) {
                if (last_cand == nums[cand]) continue;
                last_cand = nums[cand];
                selected[k] = cand;
                ans[k] = nums[cand];
                rec_func(k + 1, nums);
            }
        }
    }

    public static void main(String[] args) {
        input();
        Arrays.sort(nums);
        rec_func(1, nums);
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