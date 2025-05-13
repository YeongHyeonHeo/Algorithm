import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int[] R, W, park;

    static void input() {
        n = scan.nextInt();
        m = scan.nextInt();
        R = new int[n + 1];
        W = new int[m + 1];
        park = new int[n + 1];
        for (int i = 1; i <= n; i++) R[i] = scan.nextInt();
        for (int i = 1; i <= m; i++) W[i] = scan.nextInt();
    }

    static void pro() {
        Queue<Integer> que = new LinkedList<>();
        int sum = 0;
        for (int i = 0; i < 2*m; i++) {
            int car = scan.nextInt();
            if (car > 0) {
                que.add(car);
                for (int j = 1; j <= n; j++) {
                    if (park[j] == 0) {
                        int now = que.poll();
                        park[j] = now;
                        sum += R[j] * W[now];
                        break;
                    }
                }
            }
            else {
                for (int k = 1; k <= n; k++) {
                    if (park[k] == Math.abs(car)) {
                        park[k] = 0;
                        if (!que.isEmpty()) {
                            int now = que.poll();
                            park[k] = now;
                            sum += R[k] * W[now];
                            break;
                        }
                    }
                }
            }
        }
        sb.append(sum).append('\n');
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(' ');
            input();
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