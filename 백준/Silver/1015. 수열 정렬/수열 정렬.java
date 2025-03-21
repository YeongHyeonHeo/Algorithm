import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Elem implements Comparable<Elem> {

        int num, idx;

        @Override
        public int compareTo(Elem other) {
            // 오름차순
            return num - other.num;
            // Stable Sort -> idx는 굳이 비교 X
        }
    }

    static void input() {
        N = scan.nextInt();
        P = new int[N];
        B = new Elem[N];
        for (int i = 0; i < N; i++) {
            B[i] = new Elem();
            B[i].num = scan.nextInt();
            B[i].idx = i;
        }
    }

    static int N;
    static int[] P;
    static Elem[] B;

    static void pro() {
        Arrays.sort(B);
        for (int b_idx = 0; b_idx < N; b_idx++) {
            P[B[b_idx].idx] = b_idx;
        }
        for (int i = 0; i < N; i++) sb.append(P[i]).append(' ');
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    static class FastReader {
        BufferedReader bf;
        StringTokenizer st;

        public FastReader() {
            bf = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(bf.readLine());
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
                str = bf.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}