import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static String str;
    static int[] A;
    static ArrayList<Integer> num;

    static void input() {
        str = scan.nextLine();
        A = new int[str.length()];
        for (int i = 0; i < A.length; i++) A[i] = str.charAt(i) - '0';
        num = new ArrayList<>();
    }

    static void pro() {
        for (int i = 0 ; i < A.length; i++) {
            boolean flag = true;
            for (int n : num) {
                if (A[i] == n) {
                    flag = false;
                    // 숫자 지우기
                    num.remove(num.indexOf(n));
                    break;
                }
            }
            if (flag) num.add(A[i]);
        }
        sb.append(num.size()).append('\n');
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