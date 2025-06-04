import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();

    static String[] color = {"black", "brown", "red", "orange", "yellow",
            "green", "blue", "violet", "grey", "white"};
    static String first, second, third;
    static long num;

    static void input() {
        first = scan.nextLine();
        second = scan.nextLine();
        third = scan.nextLine();
    }

    static void pro() {
        for (int i = 0; i < 10; i++) {
            if (first.equals(color[i])) num += 10 * i;
            if (second.equals(color[i])) num += i;
        }
        for (int i = 0; i < 10; i++) {
            if (third.equals(color[i])) {
                for (int j = 0; j < i; j++) num *= 10;
                break;
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