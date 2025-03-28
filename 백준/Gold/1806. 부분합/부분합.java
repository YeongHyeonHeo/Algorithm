import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n, S;
    static int[] a;

    static void input() {
        n = scan.nextInt();
        S = scan.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) a[i] = scan.nextInt();
    }

    static void pro() {
       int R = 0, sum = 0, ans = n + 1;
       for (int L = 1; L <= n; L++) {
           // L - 1을 구간에서 제외하기
           sum -= a[L - 1];

           // R을 옮길 수 있을 때 까지 옮기기
           while (R + 1 <= n && sum < S) {
               R++;
               sum += a[R];
           }

           // [L ... R]의 합, 즉 sum이 조건을 만족하면 정답 갱신
           if (sum >= S) {
               ans = Math.min(ans, R - L + 1);
           }
       }
        // ans 값을 보고 불가능 판단
        if (ans == n + 1) ans = 0;
        System.out.println(ans);
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