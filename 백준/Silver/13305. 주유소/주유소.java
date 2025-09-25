import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();

    static int N;
    static int[] dist, cost;

    static void input() {
        N = scan.nextInt();
        dist = new int[N - 1];
        cost = new int[N];
        for (int i = 0; i < N-1; i++) dist[i] = scan.nextInt();
        for (int i = 0; i < N; i++) cost[i] = scan.nextInt();
    }

    static void pro() {
        long sum = 0;
        int minCost = cost[0];

        for (int i = 0; i < N-1; i++) {
            if (cost[i] < minCost) minCost = cost[i];
            sum += (long)minCost * dist[i];
        }

        System.out.println(sum);
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