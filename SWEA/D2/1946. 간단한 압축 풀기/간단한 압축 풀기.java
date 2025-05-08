import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, sum;
    static String[] str;

    static void input() {
        N = scan.nextInt();
        str = new String[200];
        sum = 0;
        for (int i = 0; i < N; i++) {
            String word = scan.next();
            int num = scan.nextInt();
            for (int j = sum; j < (sum+num); j++) str[j] = word;
            sum+=num;
        }
    }

    static void pro() {
        for (int i = 0; i <= sum/10; i++) {
            for (int j = 0; j < 10; j++) {
                if (str[i*10+j] == null) break;
                sb.append(str[i*10+j]);
            }
            sb.append('\n');
        }
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append('\n');
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