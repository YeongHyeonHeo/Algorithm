import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int a, b, n, w, cnt, ans1, ans2;

    static void input() {
        a = scan.nextInt();
        b = scan.nextInt();
        n = scan.nextInt();
        w = scan.nextInt();
    }

    static void pro() {
        int i = n - 1, num1 = 1, num2 = n - 1;
        while (i-- > 0) {
            if (num1 * a + num2 * b == w) {
                cnt++;
                ans1 = num1;
                ans2 = num2;
            }
            num1++;
            num2--;
        }

        if (cnt >= 2 || cnt == 0) sb.append(-1);
        else sb.append(ans1).append(' ').append(ans2);
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