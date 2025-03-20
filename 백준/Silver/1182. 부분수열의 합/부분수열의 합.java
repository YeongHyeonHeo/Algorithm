import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();

    static void input() {
        N = scan.nextInt();
        S = scan.nextInt();
        nums = new int[N + 1];
        for (int i = 1; i <= N; i++) nums[i] = scan.nextInt();
    }

    static int N, S, ans;
    static int[] nums;

    static void rec_func(int k, int value) {
        if (k == N + 1) {
            if (value == S) ans++;
        } else {
            // Include
            rec_func(k + 1, value + nums[k]);
            // Not Include
            rec_func(k + 1, value);
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1, 0);
        // ans 가 정말 "진 부분집합"만 다루는지 확인하기
        if (S == 0) {
            ans--;
        }
        System.out.println(ans);
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