import java.util.*;
import java.io.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static Queue<Integer> queue;

    static void input() {
        N = scan.nextInt();
        queue = new LinkedList<>();
        while (N-- > 0) queue.add(scan.nextInt());
    }

    static void pro() {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        int now = 1;
        while (true) {
            if (queue.peek() == now) {
                list.add(queue.poll());
                now++;
            } else {
                if (!stack.isEmpty() && stack.peek() == now) {
                    list.add(stack.pop());
                    now++;
                }
                else stack.push(queue.poll());
            }
            if (queue.isEmpty()) break;
        }

        while (!stack.isEmpty()) list.add(stack.pop());

        boolean flag = true;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - list.get(i-1) != 1) {
                flag = false;
                break;
            }
        }

        if (flag) sb.append("Nice");
        else sb.append("Sad");
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
    }
}