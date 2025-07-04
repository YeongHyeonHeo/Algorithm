import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();

    static int A, B, V;

    static void input() {
        A = scan.nextInt();
        B = scan.nextInt();
        V = scan.nextInt();
    }

    static void pro() {
        if ((V-A) % (A-B) != 0) System.out.println((V-A) / (A-B) + 2);
        else System.out.println((V-A) / (A-B) + 1);
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