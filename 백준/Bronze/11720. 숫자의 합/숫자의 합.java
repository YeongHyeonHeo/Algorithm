import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();

    static int N, sum;
    static String str;

    static void input() {
        N = scan.nextInt();
        str = scan.nextLine();
    }

    static void pro() {
        for (int i = 0; i < N; i++) {
            String s = "";
            sum += Integer.parseInt(s+str.charAt(i)); // 숫자를 문자열로 받고, 각 자릿수마다 정수형으로 변환해서 합
        }
        System.out.print(sum);
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