import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] height, weight;

    static void input() {
        N = scan.nextInt();
        height = new int[N];
        weight = new int[N];
        for (int i = 0 ; i < N; i++) {
            height[i] = scan.nextInt();;
            weight[i] = scan.nextInt();
        }
    }

    static void pro() {
        for (int i = 0; i < N; i++) {
            int ans = 1;
            for (int j = 0; j < N; j++) {
                if (height[i] < height[j] && weight[i] < weight[j]) ans++;
            }
            sb.append(ans).append(' ');
        }
        System.out.println(sb);
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