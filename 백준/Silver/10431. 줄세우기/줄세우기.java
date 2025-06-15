import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int t;
    static ArrayList<Integer> height;

    static void input() {
        t = scan.nextInt();
        height = new ArrayList<>();
    }

    static void pro() {
        int ans = 0;
        height.add(scan.nextInt());
        for (int i = 1; i < 20; i++) {
            int child = scan.nextInt();
            boolean isExist = false;
            for (int j = 0; j < height.size(); j++) {
                if (height.get(j) > child) {
                    ans += height.size() - j;
                    height.add(j, child);
                    isExist = true;
                    break;
                }
            }
            if (!isExist) height.add(child);
        }
        sb.append(t).append(' ').append(ans).append('\n');
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        while (T-- > 0) {
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