import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();

    static int[] arr;

    static void input() {
        arr = new int[3];
        for (int i = 0; i < 3; i++) arr[i] = scan.nextInt();
    }

    static void pro() {
        Arrays.sort(arr);
        System.out.println(arr[1]);
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