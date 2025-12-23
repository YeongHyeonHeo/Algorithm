import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();

    static String str;
    static int ans;

    static void input() {
        str = scan.nextLine();
    }

    static void pro() {
        Stack<Character> stack = new Stack<>(); // 스택 사용

        // 입력 받은 괄호들 하나씩 확인
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') // 여는 괄호면 스택에 넣기
                stack.push('(');
            else {
                stack.pop(); // 닫는 괄호면 스택에서 빼기
                // 이전 괄호가 여는 괄호면 레이저 -> 잘린 개수 더하기
                if (str.charAt(i - 1) == '(') ans += stack.size();
                else ans++; // 이전 괄호가 닫는 괄호면 레이저 아님 -> 마지막 잘린거 더하기
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