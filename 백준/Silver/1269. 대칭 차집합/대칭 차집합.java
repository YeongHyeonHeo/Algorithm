import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int A, B;
    static HashMap<Integer, Integer> hashMapA = new HashMap<>();
    static HashMap<Integer, Integer> hashMapB = new HashMap<>();
    static int[] arrA, arrB;

    static void input() {
        A = scan.nextInt();
        B = scan.nextInt();
        arrA = new int[A];
        arrB = new int[B];
        for (int i = 0; i < A; i++) {
            int n = scan.nextInt();
            arrA[i] = n;
            hashMapA.put(n, 0);
        }
        for (int i = 0; i < B; i++) {
            int n = scan.nextInt();
            arrB[i] = n;
            hashMapB.put(n, 0);
        }
    }

    static void pro() {
        for (int i : arrA) {
            if (hashMapB.containsKey(i)) A--;
        }
        for (int i : arrB) {
            if (hashMapA.containsKey(i)) B--;
        }
        System.out.println(A + B);
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