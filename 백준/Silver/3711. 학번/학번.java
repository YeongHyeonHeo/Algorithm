import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int G;
    static int[] arr;

    static void input() {
        G = scan.nextInt();
        arr = new int[G];
        for (int i = 0; i < G; i++) arr[i] = scan.nextInt();
    }

    static void pro() {
        int ans = 1;

        while (true) {
            ArrayList<Integer> list = new ArrayList<>();
            boolean flag = true;

            for (int num : arr) {
                int mod = num % ans;
                if (list.contains(mod)) {
                    flag = false;
                    break;
                }
                list.add(mod);
            }

            if (flag) break;
            ans++;
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        while (T-- > 0) {
            input();
            pro();
        }
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