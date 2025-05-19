import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static String str;
    static ArrayList<Character> ch;
    static int H;
    static int[] idx;

    static void input() {
        str = scan.nextLine();
        ch = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) ch.add(str.charAt(i));
        H = scan.nextInt();
        idx = new int[H];
        for (int i = 0; i < H; i++) idx[i] = scan.nextInt();
    }

    static void pro() {
        Arrays.sort(idx);
        for (int i = 0; i < H; i++) ch.add(i + idx[i], '-');
        for (char c : ch) sb.append(c);
        sb.append('\n');
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