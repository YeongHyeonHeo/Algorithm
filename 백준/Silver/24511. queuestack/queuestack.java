import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] A, B, C;

    static void input() {
        N = scan.nextInt();
        A = new int[N];
        B = new int[N];
        for (int i = 0; i < N; i++) A[i] = scan.nextInt();
        for (int i = 0; i < N; i++) B[i] = scan.nextInt();
        M = scan.nextInt();
        C = new int[M];
        for (int i = 0; i < M; i++) C[i] = scan.nextInt();
    }

    static void pro() {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if (A[i] == 0) deque.add(B[i]);
        }
        for (int x : C) {
            deque.addFirst(x);
            sb.append(deque.pollLast()).append(' ');
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
    }
}