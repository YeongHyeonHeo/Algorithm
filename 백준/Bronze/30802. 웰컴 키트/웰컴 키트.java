import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, T, P;
    static int[] size;

    static void input() {
        N = scan.nextInt();
        size = new int[6];
        for (int i = 0; i < 6; i++) size[i] = scan.nextInt();
        T = scan.nextInt();
        P = scan.nextInt();
    }

    static void pro() {
        int t = 0;
        for (int num : size) {
            if (num == 0) continue;
            t += (num - 1) / T + 1;
        }
        sb.append(t).append('\n').append(N / P).append(' ').append(N % P);
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