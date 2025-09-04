import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static String s;
    static int[] arr;

    static void input() {
        s = scan.nextLine();
        arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) arr[i] = s.charAt(i)-'0';
    }

    static void pro() {
        int[] cnt = new int[10];
        for (int i = 0; i < arr.length; i++) cnt[arr[i]]++;
        for (int i = 9; i >= 0; i--) {
            if (cnt[i] == 0) continue;
            int c = cnt[i];
            while (c-- > 0) sb.append(i);
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        pro();
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