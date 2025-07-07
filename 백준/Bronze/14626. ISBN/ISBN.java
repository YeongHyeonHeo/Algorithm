import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();

    static String num;

    static void input() {
        num = scan.nextLine();
    }

    static void pro() {
        int sum = 0, idx = 0;
        for (int i = 0; i < 13; i++) {
            if (num.charAt(i) == '*') {
                idx = i;
                continue;
            }
            if (i % 2 == 0) sum += num.charAt(i) - '0';
            else sum += (num.charAt(i) - '0') * 3;
        }

        for (int i = 0; i < 10; i++) {
            if (idx % 2 == 0) {
                if ((i + sum) % 10 == 0) {
                    System.out.print(i);
                    return;
                }
            }
            else {
                if ((i * 3 + sum) % 10 == 0) {
                    System.out.print(i);
                    return;
                }
            }
        }
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
