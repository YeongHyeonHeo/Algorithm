import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] A;
    static ArrayList<Integer> up, down;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) A[i] = scan.nextInt();
        up = new ArrayList<>();
        down = new ArrayList<>();
    }

    static void pro() {
        for (int i = 1; i <= N-1; i++) {
            if (A[i] < A[i+1]) up.add(A[i+1]-A[i]);
            else if (A[i] > A[i+1]) down.add(A[i]-A[i+1]);
        }
        Collections.sort(up, Collections.reverseOrder());
        Collections.sort(down, Collections.reverseOrder());
        if (up.isEmpty()) sb.append("0 ");
        else sb.append(up.get(0)).append(' ');
        if (down.isEmpty()) sb.append("0\n");
        else sb.append(down.get(0)).append('\n');
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

        double nextDouble() {
            return Double.parseDouble(next());
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