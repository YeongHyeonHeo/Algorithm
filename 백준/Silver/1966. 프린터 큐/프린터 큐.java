import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();

    static int N, M;
    static int[][] arr;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            arr[i][0] = scan.nextInt();
            arr[i][1] = i;
        }
    }

    static void pro() {
        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < N; i++) q.add(arr[i]);

        while (true) {
            int val = q.peek()[0];
            boolean flag = false;
            for (int[] a : q) {
                if (a[0] > val) {
                    q.offer(q.poll());
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                int[] poll = q.poll();
                cnt++;
                if (poll[1] == M) break;
            }
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        while (T-- > 0) {
            input();
            pro();
        }
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