import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] arr; // 2차원 평면 위의 점

    static void input() {
        N = scan.nextInt();
        arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            arr[i][0] = scan.nextInt();
            arr[i][1] = scan.nextInt();
        }
    }

    static void pro() {
        Arrays.sort(arr, (e1, e2) -> {
            if (e1[0] == e2[0]) return e1[1] - e2[1];
            return e1[0] - e2[0];
        });

        for (int i = 0; i < N; i++) sb.append(arr[i][0]).append(' ').append(arr[i][1]).append('\n');
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
    }
}