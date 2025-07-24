import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();

    static int K;
    static Stack<Integer> stack;

    static void input() {
        K = scan.nextInt();
        stack = new Stack<>();
    }

    static void pro() {
        while (K-- > 0) {
            int num = scan.nextInt();
            if (num == 0) stack.pop();
            else stack.push(num);
        }

        int sum = 0;
        for (int i : stack) sum += i;
        System.out.println(sum);
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