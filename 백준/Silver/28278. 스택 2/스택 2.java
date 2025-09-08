import java.util.*;
import java.io.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;

    static void input() {
        N = scan.nextInt();
    }

    static void pro() {
        Stack<Integer> stack = new Stack<>();
        while (N-- > 0){
            int i = scan.nextInt();
            if (i == 1) {
                int X = scan.nextInt();
                stack.push(X);
            } else if (i == 2) {
                if (!stack.isEmpty()) sb.append(stack.pop()).append('\n');
                else sb.append(-1).append('\n');
            } else if (i == 3) {
                sb.append(stack.size()).append('\n');
            } else if (i == 4) {
                if (stack.isEmpty()) sb.append(1).append('\n');
                else sb.append(0).append('\n');
            } else {
                if (!stack.isEmpty()) sb.append(stack.peek()).append('\n');
                else sb.append(-1).append('\n');
            }
        }

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
    }
}