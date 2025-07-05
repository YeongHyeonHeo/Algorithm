import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int a, b;

    static void input() {
        a = scan.nextInt();
        b = scan.nextInt();
    }

    static void pro() {
        // 최대공약수
        int min = Math.min(a, b);
        for (int i = 1; i <= min; i++) {
            if (min % i == 0) {
                min /= i;
                if (a % min == 0 && b % min == 0) break;
            }
            min = Math.min(a, b);
        }

        // 최소공배수
        int max = Math.max(a, b);
        while (true) {
            if (max % a == 0 && max % b == 0) break;
            max += Math.max(a, b);
        }

        sb.append(min).append('\n').append(max);
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