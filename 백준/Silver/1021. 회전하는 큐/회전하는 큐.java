import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] arr;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new int[M];
        for (int i = 0; i < M; i++) arr[i] = scan.nextInt();
    }

    static void pro() {
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) deque.add(i);

        int ans = 0;
        for (int find : arr) {
            int idx = deque.indexOf(find);
            if (idx > deque.size()/2) {
                // 오른쪽 이동
                while (deque.peek() != find) {
                    deque.addFirst(deque.pollLast());
                    ans++;
                }
            } else {
                // 왼쪽 이동
                while (deque.peek() != find) {
                    deque.add(deque.poll());
                    ans++;
                }
            }
            deque.poll();
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