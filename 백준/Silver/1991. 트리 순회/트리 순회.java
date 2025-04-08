import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] childs;

    static void input() {
        N = scan.nextInt();
        childs = new int[30][2];
        for (int i = 0; i < N; i++) {
            char curCh = scan.next().charAt(0);
            int cur = curCh - 'A';
            for (int j = 0; j < 2; j++) {
                char ch = scan.next().charAt(0);
                if (ch != '.') childs[cur][j] = ch - 'A';
                else childs[cur][j] = -1;
            }
        }
    }

    static void pre_order(int x) {
        if (x == -1) return;
        sb.append((char)(x + 'A'));
        pre_order(childs[x][0]);
        pre_order(childs[x][1]);
    }

    static void in_order(int x) {
        if (x == -1) return;
        in_order(childs[x][0]);
        sb.append((char)(x + 'A'));
        in_order(childs[x][1]);
    }

    static void post_order(int x) {
        if (x == -1) return;
        post_order(childs[x][0]);
        post_order(childs[x][1]);
        sb.append((char)(x + 'A'));
    }

    static void pro() {
        pre_order(0);
        sb.append('\n');
        in_order(0);
        sb.append('\n');
        post_order(0);

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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
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