import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();

    static String[] s;

    static void input() {
        s = new String[3];
        for (int i = 0; i < 3; i++) {
            s[i] = scan.nextLine();
        }
    }

    static void pro() {
        int num = 0, idx = 0;
        for (int i = 0; i < 3; i++) {
            if ('0' <= s[i].charAt(0) && s[i].charAt(0) <= '9') {
                num = Integer.parseInt(s[i]);
                idx = i;
                break;
            }
        }
        num += 3 - idx;

        if (num % 3 == 0 && num % 5 == 0) {
            System.out.println("FizzBuzz");
            return;
        }
        if (num % 3 == 0) {
            if (num % 5 != 0) {
                System.out.println("Fizz");
                return;
            }
        }
        if (num % 3 != 0) {
            if (num % 5 == 0) {
                System.out.println("Buzz");
                return;
            }
        }
        System.out.println(num);
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