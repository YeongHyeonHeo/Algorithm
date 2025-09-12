import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static HashMap<String, Integer> hashMap = new HashMap<>();
    static int N, M;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        for (int i = 0; i < N; i++) hashMap.put(scan.nextLine(), 0);
    }

    static void pro() {
        int cnt = 0;
        while (M-- > 0) {
            String str = scan.nextLine();
            if (hashMap.containsKey(str)) cnt++;
        }
        System.out.println(cnt);
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