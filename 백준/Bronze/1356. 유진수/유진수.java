import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static String str;

    static void input() {
        str = scan.nextLine();
    }

    static void pro() {
        boolean ans = false;
        for (int i = 0; i < str.length()-1; i++) {
            String num1 = str.substring(0, i + 1);
            String num2 = str.substring(i + 1);
            int left = 1, right = 1;
            for (int j = 0; j < num1.length(); j++) left *= (num1.charAt(j)-'0');
            for (int j = 0; j < num2.length(); j++) right *= (num2.charAt(j)-'0');
            if (left == right) {
                ans = true;
                break;
            }
        }

        if (ans) sb.append("YES");
        else sb.append("NO");
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