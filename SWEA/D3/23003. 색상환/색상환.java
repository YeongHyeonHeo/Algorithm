import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static String[] color = {"red", "orange", "yellow", "green", "blue", "purple"};
    static HashMap<String, Integer> map = new HashMap<>();

    static void init() {
        for (int i = 0; i < color.length; i++) map.put(color[i], i+1);
    }

    static int c1, c2;

    static void input() {
        c1 = map.get(scan.next());
        c2 = map.get(scan.next());
    }

    static void pro() {
        if (c1 == c2) sb.append("E\n");
        else if (Math.abs(c1 - c2) == 3) sb.append("C\n");
        else if (Math.abs(c1 - c2) == 1 || Math.abs(c1 - c2) == 5) sb.append("A\n");
        else sb.append("X\n");
    }

    public static void main(String[] args) {
        init();
        int T = scan.nextInt();
        for (int t = 1; t <= T; t++) {
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