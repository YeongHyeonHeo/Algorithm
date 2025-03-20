import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        nums = new int[N + 1];
        operators = new int[5];
        for (int i = 1; i <= N; i++) nums[i] = scan.nextInt();
        for (int i = 1; i <= 4; i++) operators[i] = scan.nextInt();
    }

    static int N;
    static int[] nums, operators;

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    static int cal(int operand1, int operator, int operand2) {
        if (operator == 1) {
            return operand1 + operand2;
        } else if (operator == 2) {
            return operand1 - operand2;
        } else if (operator == 3) {
            return operand1 * operand2;
        } else return operand1 / operand2;
    }

    static void rec_func(int k, int value) {
        if (k == N) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            for (int i = 1; i <= 4; i++) {
                if (operators[i] >= 1) {
                    operators[i]--;
                    rec_func(k + 1, cal(value, i, nums[k + 1]));
                    operators[i]++;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1, nums[1]);
        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());
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

        long nextLong() {
            return Long.parseLong(next());
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