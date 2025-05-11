import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static ArrayList<Integer> A;

    static void input() {
        N = scan.nextInt();
        A = new ArrayList<>();
        for (int i = 0; i < N; i++) A.add(scan.nextInt());
    }

    static void pro() {
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            String l = scan.next();
            int x = scan.nextInt();
            int cnt = scan.nextInt();
            for (int j = 0; j < cnt; j++) {
                A.add(x++, scan.nextInt());
            }
        }
        for (int i = 0; i < 10; i++) sb.append(A.get(i)).append(' ');
        sb.append('\n');
    }

    public static void main(String[] args) {
        for (int t = 1; t <= 10; t++) {
            sb.append('#').append(t).append(' ');
            input();
            pro();
        }
        System.out.print(sb);
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