import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();

    static int N;
    static Queue<Integer> queue;

    static void input() {
        N = scan.nextInt();
        queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) queue.add(i);
    }

    static void pro() {
        if (N == 1) {
            System.out.println(1);
            return;
        }
        while (true) {
            queue.poll();
            if (queue.size() == 1) break;
            queue.add(queue.poll());
        }
        System.out.println(queue.poll());
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