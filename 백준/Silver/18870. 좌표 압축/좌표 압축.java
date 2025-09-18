import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] arr;
    static int[] ans;

    static void input() {
        N = scan.nextInt();
        arr = new int[N][2];
        ans = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i][0] = scan.nextInt();
            arr[i][1] = i;
        }
        // [2,0] [4,1] [-10,2] [4,3] [-9,4]
        // [-10,2] [-9,4] [2,0] [4,1] [4,3]
    }

    static void pro() {
        Arrays.sort(arr, (o1, o2) -> {
            return o1[0] -o2[0];
        });
        ans[arr[0][1]] = 0;
        int idx = 0;
        for (int i = 1; i < N; i++) {
            if (arr[i][0] == arr[i-1][0]) ans[arr[i][1]] = idx;
            else ans[arr[i][1]] = ++idx;
        }
        for (int i : ans) sb.append(i).append(' ');
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