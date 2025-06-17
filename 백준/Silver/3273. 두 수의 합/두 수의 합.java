import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n, x;
    static int[] num;
    static boolean[] exist;

    static void input() {
        n = scan.nextInt();
        num = new int[n];
        exist = new boolean[1000001];
        for (int i = 0; i < n; i++) {
            int a = scan.nextInt();
            num[i] = a;
            exist[a] = true;
        }
        x = scan.nextInt();
    }

    static void pro() {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int pairValue = x - num[i];
            if (1 <= pairValue && pairValue <= 1000000) {
                ans += exist[pairValue] ? 1 : 0;
            }
        }
        System.out.println(ans/2);
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