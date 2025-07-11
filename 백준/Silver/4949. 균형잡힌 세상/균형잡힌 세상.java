import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static String str;

    static void pro() {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '[') stack.push(c);
            else if (c == ')') {
                if (stack.empty() || stack.peek() != '(') {
                    sb.append("no\n");
                    return;
                }
                else stack.pop();
            }
            else if (c == ']') {
                if (stack.empty() || stack.peek() != '[') {
                    sb.append("no\n");
                    return;
                }
                else stack.pop();
            }
        }

        if (stack.empty()) sb.append("yes\n");
        else sb.append("no\n");
    }

    public static void main(String[] args) {
        while (true) {
            str = scan.nextLine();
            if (str.length() == 1) break;
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