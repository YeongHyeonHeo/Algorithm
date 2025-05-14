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
    }

    static void pro() {
        int cnt = 0;
        while (N-- > 0) {
            int start = scan.nextInt();
            int end = scan.nextInt();
            for (int i = 0; i < A.size(); i+=2) {
                int a = A.get(i);
                int b = A.get(i+1);
                if ((start < a && end > b) || (start > a && end < b)) cnt++;
            }
            A.add(start);
            A.add(end);
        }
        sb.append(cnt).append('\n');
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