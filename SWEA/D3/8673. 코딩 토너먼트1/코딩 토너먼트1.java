import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int K;
    static ArrayList<Integer> A;

    static void input() {
        K = scan.nextInt();
        A = new ArrayList<>();
        int num = 1;
        for (int i = 0; i < K; i++) num *= 2;
        for (int i = 0; i < num; i++) A.add(scan.nextInt());
    }

    static void pro() {
        int ans = 0;
        while (A.size() != 1) {
            for (int i = 0; i <= A.size()-2; i++) {
                if (A.get(i) > A.get(i+1)) {
                    ans += A.get(i) - A.get(i+1);
                    A.remove(i+1);
                }
                else {
                    ans += A.get(i+1) - A.get(i);
                    A.remove(i);
                }
            }
        }
        sb.append(ans).append('\n');
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        for (int t = 1; t <= T; t++) {
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