import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;

    static void input() {
        N = scan.nextInt();
    }

    static void pro() {
        String num = Integer.toString(N);
        if (N < 10) num = "0" + N;
        String num2 = num;

        int cnt = 0;
        while (true) {
            cnt++;
            int sum = (num2.charAt(0) - '0') + (num2.charAt(1) - '0');
            String sum2 = Integer.toString(sum);
            if (sum < 10) sum2 = "0" + sum;
            String newNum = Character.toString(num2.charAt(1)) + sum2.charAt(1);
            if (num.equals(newNum)) break;
            num2 = newNum;
        }
        sb.append(cnt);
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