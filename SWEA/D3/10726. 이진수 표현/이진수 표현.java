import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static char[] bin;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        bin = new char[30];
        for (int i = 0; i < 30; i++) bin[i] = '0';
    }

    static void pro() {
        String binary = Integer.toBinaryString(M);
        int idx = 29;
        for (int i = binary.length()-1; i >= 0; i--) bin[idx--] = binary.charAt(i);

        boolean flag = true;
        for (int i = 1; i <= N; i++) {
            if (bin[30-i] == '0') {
                flag = false;
                break;
            }
        }
        if (flag) sb.append("ON\n");
        else sb.append("OFF\n");
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