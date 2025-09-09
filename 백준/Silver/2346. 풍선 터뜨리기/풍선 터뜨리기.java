import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static Deque<int[]> deque;

    static void input() {
        N = scan.nextInt();
        deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) deque.add(new int[]{scan.nextInt(), i});
    }

    static void pro() {
        while (!deque.isEmpty()) {
            int[] arr = deque.poll();
            sb.append(arr[1]).append(" ");
            if (deque.isEmpty()) break;
            if (arr[0] > 0) {
                for (int i = 0; i < arr[0]-1; i++) deque.add(deque.poll());
            } else {
                for (int i = 0; i < -arr[0]; i++) deque.addFirst(deque.pollLast());
            }
        }
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