import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static String[] str;

    static void input() {
        N = scan.nextInt();
        str = new String[N];
        for (int i = 0; i < N; i++) str[i] = scan.next().split("\\.")[1];
    }

    static void pro() {
        Arrays.sort(str);
        int cnt = 1;
        for (int i = 1; i < N; i++) {
            if (str[i].equals(str[i-1])) {
                cnt++;
            }
            else {
                sb.append(str[i-1]).append(" ").append(cnt).append('\n');
                cnt = 1;
            }
        }
        sb.append(str[N-1]).append(" ").append(cnt);
        System.out.println(sb.toString());
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

        String nextLine(){
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