import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static HashMap<String, Integer> hashMap = new HashMap<>();
    static HashMap<Integer, String> hashMap2 = new HashMap<>();
    static int N, M;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        for (int i = 1; i <= N; i++) {
            String str = scan.nextLine();
            hashMap.put(str, i);
            hashMap2.put(i, str);
        }
    }

    static void pro() {
        while (M-- > 0) {
            String quiz = scan.nextLine();
            if ('0' <= quiz.charAt(0) && quiz.charAt(0) <= '9') {
                int q = Integer.parseInt(quiz);
                sb.append(hashMap2.get(q)).append('\n');
            } else sb.append(hashMap.get(quiz)).append('\n');
        }
        System.out.print(sb);
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