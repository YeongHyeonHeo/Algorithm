import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();

    static int N, M, ans;
    static int[][] arr;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = scan.nextLine();
            for (int j = 0; j < M; j++) arr[i][j] = str.charAt(j)-'0';
        }
    }

    static void pro() {
        ans = 1; // 최소 넓이는 1 (1x1 정사각형)
        int maxLen = Math.min(N, M);

        for (int size = 1; size < maxLen; size++) {
            for (int i = 0; i + size < N; i++) {
                for (int j = 0; j + size < M; j++) {
                    int a = arr[i][j];
                    int b = arr[i][j + size];
                    int c = arr[i + size][j];
                    int d = arr[i + size][j + size];

                    if (a == b && b == c && c == d) {
                        ans = Math.max(ans, (size + 1) * (size + 1));
                    }
                }
            }
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