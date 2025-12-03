import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();

    static int N;
    static int[] P;

    static void input() {
        N = scan.nextInt();
        P = new int[N];
        for (int i = 0; i < N; i++) P[i] = scan.nextInt();
    }

    static void pro() {
        Arrays.sort(P); // 정렬 먼저
        int prev = 0; // 대기시간 누적합
        int ans = 0; // 사람별 대기시간 합

        for (int i = 0; i < N; i++) {
            ans += prev + P[i];
            prev += P[i];
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
    }
}