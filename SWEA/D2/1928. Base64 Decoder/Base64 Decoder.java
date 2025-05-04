import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static String str;

    static void input() {
        str = scan.nextLine();
    }

    static void pro() {
        String binary = "";
        for (int i = 0; i < str.length(); i++) {
            if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
                int num =  str.charAt(i) - 'A';
                binary += String.format("%06d", Integer.parseInt(Integer.toBinaryString(num)));
            } else if ('a' <= str.charAt(i) && str.charAt(i) <= 'z') {
                int num =  str.charAt(i) - 'a' + 26;
                binary += String.format("%06d", Integer.parseInt(Integer.toBinaryString(num)));
            } else if ('0' <= str.charAt(i) && str.charAt(i) <= '9') {
                int num =  str.charAt(i) - '0' + 52;
                binary += String.format("%06d", Integer.parseInt(Integer.toBinaryString(num)));
            } else if (str.charAt(i) == '+') binary += String.format("%06d", Integer.parseInt(Integer.toBinaryString(62)));
            else binary += String.format("%06d", Integer.parseInt(Integer.toBinaryString(63)));
        }

        String ans = "";
        for (int i = 0; i <= binary.length()-8; i+=8) {
            String decode = "";
            for (int j = 0; j < 8; j++) decode += binary.charAt(i+j);
            char ch = (char)Integer.parseInt(decode, 2);
            ans += String.valueOf(ch);
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
        System.out.println(sb);
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