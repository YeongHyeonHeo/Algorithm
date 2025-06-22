import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();

    static int a, b, c;

    static void pro() {
        if (a * a + b * b == c * c) System.out.println("right");
        else if (b * b + c * c == a * a) System.out.println("right");
        else if (a * a + c * c == b * b) System.out.println("right");
        else System.out.println("wrong");

    }

    public static void main(String[] args) {
        while (true) {
            a = scan.nextInt();
            b = scan.nextInt();
            c = scan.nextInt();
            if (a == 0 && b == 0 && c == 0) break;
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