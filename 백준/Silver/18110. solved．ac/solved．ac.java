import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] arr;

    static void input() {
        n = scan.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = scan.nextInt();
    }

    static void pro() {
        Arrays.sort(arr);
        int no = (int)Math.round(n * 0.15);
        int sum = 0;
        for (int i = no; i < n - no; i++) sum += arr[i];
        System.out.println(Math.round((double)sum/(n-2*no)));
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