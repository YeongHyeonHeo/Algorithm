import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) A[i] = scan.nextInt();
        B = new int[N];
        P = new int[N];
    }

    static int N;
    static int[] A, B, P;

    static void ans() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++){
                if (A[i] == B[j]) {
                    for (int k = 0; k < N; k++) {
                        if (P[k] != j) P[i] = j;
                        B[j] = -1;
                    }
                    break;
                }
            }
        }
        for (int i = 0; i < N; i++) sb.append(P[i]).append(' ');
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        B = A.clone();
        Arrays.sort(B);
        ans();
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