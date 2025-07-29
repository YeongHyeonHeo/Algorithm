import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K;

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
    }

    static void pro() {
        ArrayList<Integer> list = new ArrayList<>();
        sb.append('<');
        for (int i = 1; i <= N; i++) list.add(i);

        int idx = 0;
        while (list.size() != 1) {
            if (idx >= list.size()) idx = 0;
            for (int i = 0; i < K-1; i++) {
                idx++;
                if (idx >= list.size()) idx = 0;
            }
            sb.append(list.get(idx)).append(", ");
            list.remove(idx);
        }

        sb.append(list.get(0)).append('>');
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