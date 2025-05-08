import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static String[] str;

    static void input() {
        N = scan.nextInt();
        str = new String[8];
        for (int i = 0; i < 8; i++) str[i] = scan.nextLine();
    }

    static void pro() {
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8-N+1; j++) {
                boolean flag = true;
                for (int k = 0; k < N/2; k++) {
                    if (str[i].charAt(j+k) != str[i].charAt(j+N-k-1)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) cnt++;

                flag = true;
                for (int k = 0; k < N/2; k++) {
                    if (str[j+k].charAt(i) != str[j+N-k-1].charAt(i)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) cnt++;
            }
        }
        sb.append(cnt).append('\n');
    }

    public static void main(String[] args) {
        for (int t = 1; t <= 10; t++) {
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