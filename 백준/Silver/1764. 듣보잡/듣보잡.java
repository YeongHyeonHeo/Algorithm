import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static String[] A, B;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new String[N + 1];
        B = new String[M + 1];
        for (int i = 1; i <= N; i++) A[i] = scan.nextLine();
        for (int i = 1; i <= M; i++) B[i] = scan.nextLine();
    }

    static int cnt = 0;

    static String ans(String[] A, int L, int R, String name) {
        String res = "";
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid].equals(name)) {
                cnt++;
                return name;
            }
            else if (A[mid].compareTo(name) < 0) L = mid + 1;
            else R = mid - 1;
        }
        return res;
    }

    static ArrayList<String> strArr;

    static void pro() {
        Arrays.sort(A, 1, N + 1);
        Arrays.sort(B, 1, M + 1);
        strArr = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            String str = ans(A, 1, N, B[i]);
            if (!str.isEmpty()) strArr.add(str);
        }
        sb.append(cnt).append('\n');
        for (String s : strArr) {
            sb.append(s).append('\n');
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

        long nextLong() {
            return Long.parseLong(next());
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