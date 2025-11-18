import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static String s;

    static void input() {
        s = scan.nextLine();
    }

    static void pro() {
        // 스택 사용
        Stack<Character> stack = new Stack<>();

        // '(' 이면 스택에 push, ')' 이면 pop 하면서
        // 다 진행했을 때 '('가 남거나
        // 비어있는데 pop 하면 "NO"
        // 다 진행했을 때 스택이 비어있으면 "YES"
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push('(');
            if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    sb.append("NO").append('\n');
                    return;
                } else stack.pop();
            }
        }

        if (stack.isEmpty()) sb.append("YES").append('\n');
        else sb.append("NO").append('\n');
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        // 테스트 수만큼 반복
        while (T-- > 0) {
            input();
            pro();
        }
        System.out.print(sb);
    }

    public static class FastReader {
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