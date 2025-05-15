import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static String str;
    static char[][] ch;

    static void input() {
        str = scan.nextLine();
        ch = new char[4][14];
    }

    static void pro() {
        for (int i = 0; i < str.length(); i+=3) {
            char c = str.charAt(i);
            String s = "";
            for (int j = 1; j < 3; j++) {
                s += str.charAt(i+j);
            }
            int num = Integer.parseInt(s);
            if (c == 'S') ch[0][num]++;
            else if (c == 'D') ch[1][num]++;
            else if (c == 'H') ch[2][num]++;
            else ch[3][num]++;
        }

        int[] cnt = new int[4];
        boolean flag = true;
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                if (ch[i][j] > 1) {
                    flag = false;
                    break;
                } else {
                    if (ch[i][j] == 0) cnt[i]++;
                }
            }
            if (!flag) break;
        }
        if (flag) {
            for (int i = 0; i < 4; i++) sb.append(cnt[i]).append(' ');
            sb.append('\n');
        } else sb.append("ERROR\n");
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