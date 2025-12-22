import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N; // 명령의 수

    static void input() {
        N = scan.nextInt();
    }

    static void pro() {
        Deque<Integer> q = new LinkedList<>(); // 덱으로 사용

        while (N-- > 0) { // 명령 수 만큼 반복
            String cmd = scan.next(); // 명령 입력받음
            if (cmd.equals("push")) {
                q.add(scan.nextInt());
            } else if (cmd.equals("pop")) {
                if (q.isEmpty()) sb.append("-1\n");
                else sb.append(q.poll()).append('\n');
            } else if (cmd.equals("size")) {
                sb.append(q.size()).append('\n');
            } else if (cmd.equals("empty")) {
                if (q.isEmpty()) sb.append("1\n");
                else sb.append("0\n");
            } else if (cmd.equals("front")) {
                if (q.isEmpty()) sb.append("-1\n");
                else sb.append(q.peek()).append('\n');
            } else {
                if (q.isEmpty()) sb.append("-1\n");
                else sb.append(q.peekLast()).append('\n');
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