import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static String str;
    static ArrayList<Integer> A;

    static void input() {
        N = scan.nextInt();
        str = scan.next();
        A = new ArrayList<>();
        for (int i = 0; i < N; i++) A.add(str.charAt(i) - '0');
    }

    static void pro() {
        while (true) {
            boolean flag = false;
            for (int i = 0; i < A.size()-1; i++) {
                if (A.get(i) == A.get(i+1)) {
                    A.remove(i);
                    A.remove(i);
                    flag = true;
                }
            }
            if (!flag) break;
        }
        for (int i : A) sb.append(i);
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