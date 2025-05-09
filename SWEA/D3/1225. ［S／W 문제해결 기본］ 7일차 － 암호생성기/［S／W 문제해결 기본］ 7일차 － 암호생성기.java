import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static ArrayList<Integer> A;

    static void input() {
        A = new ArrayList<>();
        for (int i = 0; i < 8; i++) A.add(scan.nextInt());
    }

    static void pro() {
        while (A.get(A.size()-1) != 0) {
            for (int i = 1; i <= 5; i++) {
                if (A.get(0)-i < 0) A.add(0);
                else A.add(A.get(0)-i);
                A.remove(0);
                if (A.get(A.size()-1) == 0) break;
            }
        }
        for (int i : A) sb.append(i).append(' ');
        sb.append('\n');
    }

    public static void main(String[] args) {
        for (int t = 0; t < 10; t++) {
            int T = scan.nextInt();
            sb.append('#').append(T).append(' ');
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