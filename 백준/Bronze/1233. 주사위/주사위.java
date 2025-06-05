import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();

    static int s1, s2, s3;
    static int[] cnt;

    static void input() {
        s1 = scan.nextInt();
        s2 = scan.nextInt();
        s3 = scan.nextInt();
        cnt = new int[s1+s2+s3+1];
    }

    static void pro() {
        for (int i = 1; i <= s1; i++) {
            for (int j = 1; j <= s2; j++) {
                for (int k = 1; k <= s3; k++) cnt[i+j+k]++;
            }
        }
        int max = 0, ans = 0;
        for (int i = 3; i <= s1+s2+s3; i++) {
            if (cnt[i] > max) {
                max = cnt[i];
                ans = i;
            }
        }
        System.out.println(ans);
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
    }
}