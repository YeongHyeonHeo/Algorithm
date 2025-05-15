import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static String str1, str2;
    static char[] zero = {'C','E','F','G','H','I','J','K','L','M','N','S',
            'T','U','V','W','X','Y','Z'};
    static char[] one = {'A','D','O','P','Q','R'};
    static HashMap<Character, Integer> map = new HashMap<>();

    static void makeMap() {
        for (char c : zero) map.put(c, 0);
        for (char c : one) map.put(c, 1);
        map.put('B', 2);
    }

    static void input() {
        str1 = scan.next();
        str2 = scan.next();
    }

    static void pro() {
        boolean flag = true;
        if (str1.length() != str2.length()) sb.append("DIFF\n");
        else {
            for (int i = 0; i < str1.length(); i++) {
                if (map.get(str1.charAt(i)) != map.get(str2.charAt(i))) {
                    flag = false;
                    break;
                }
            }
            if (flag) sb.append("SAME\n");
            else sb.append("DIFF\n");
        }
    }

    public static void main(String[] args) {
        makeMap();
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