import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] A, cnt;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) A[i] = scan.nextInt();
        cnt = new int[100000 + 1];
    }

    static void pro() {
        long ans = 0; // long 타입 주의

        for (int L = 1, R = 0; L <= N; L++) {
            // R을 옮길 수 있을 만큼 옮긴다
            while (R + 1 <= N && cnt[A[R+1]] == 0) {
                R++;
                cnt[A[R]]++;
            }
            // 정답 갱신
            ans += R - L + 1;
            // L을 옮겨주면서 A[L]의 개수를 감소시킨다
            cnt[A[L]]--;
        }
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