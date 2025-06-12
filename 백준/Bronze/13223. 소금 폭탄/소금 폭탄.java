import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static String now, salt;

    static void input() {
        now = scan.nextLine();
        salt = scan.nextLine();
    }

    static void pro() {
        int H = Integer.parseInt(now.split(":")[0]);
        int M = Integer.parseInt(now.split(":")[1]);
        int S = Integer.parseInt(now.split(":")[2]);
        int H2 = Integer.parseInt(salt.split(":")[0]);
        int M2 = Integer.parseInt(salt.split(":")[1]);
        int S2 = Integer.parseInt(salt.split(":")[2]);

        int total = H * 3600 + M * 60 + S;
        int total2 = H2 * 3600 + M2 * 60 + S2;
        int ansH = 0, ansM = 0, ansS = 0, time = 0;

        if (total < total2) time = total2 - total;
        else time = 24 * 3600 - total + total2;

        ansH = time / 3600;
        ansM = time % 3600 / 60;
        ansS = time % 3600 % 60;

        if (ansH < 10) sb.append("0").append(ansH).append(":");
        else sb.append(ansH).append(":");
        if (ansM < 10) sb.append("0").append(ansM).append(":");
        else sb.append(ansM).append(":");
        if (ansS < 10) sb.append("0").append(ansS);
        else sb.append(ansS);
        System.out.print(sb);
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