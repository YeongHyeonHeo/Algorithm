import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Dot implements Comparable<Dot> {
        public int x, y;

        @Override
        public int compareTo(Dot other) {
            if (y != other.y) return y - other.y;
            return x - other.x;
        }
    }

    static int N;
    static Dot[] dots;

    static void input() {
        N = scan.nextInt();;
        dots = new Dot[N];
        for (int i = 0; i < N; i++) {
            dots[i] = new Dot();
            dots[i].x = scan.nextInt();
            dots[i].y = scan.nextInt();
        }
    }

    static void pro() {
        Arrays.sort(dots);
        for (Dot d : dots) sb.append(d.x).append(' ').append(d.y).append('\n');
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