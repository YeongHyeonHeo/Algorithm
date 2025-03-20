import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        L = scan.nextInt();
        C = scan.nextInt();
        alpa = new char[C + 1];
        for (int i = 1; i <= C; i++) alpa[i] = scan.next().charAt(0);
        selected = new int[L + 1];
        ans = new char[L + 1];
    }

    static int L, C;
    static char[] alpa, ans;
    static int[] selected;

    static boolean contain(char[] ans) {
        int m_cnt = 0;
        int j_cnt = 0;
        for (int i = 1; i <= L; i++) {
            if (ans[i] == 'a' || ans[i] == 'e' || ans[i] == 'i' || ans[i] == 'o' || ans[i] == 'u')
                m_cnt++;
            else j_cnt++;
        }
        return m_cnt >= 1 && j_cnt >= 2;
    }

    static void rec_func(int k, char[] alpa) {
        if (k == L + 1) {
            if (contain(ans)) {
                for (int i = 1; i <= L; i++) sb.append(ans[i]);
                sb.append('\n');
            }
        } else {
            for (int cand = selected[k-1] + 1; cand <= C; cand++) {
                selected[k] = cand;
                ans[k] = alpa[cand];
                rec_func(k + 1, alpa);
            }
        }
    }

    public static void main(String[] args) {
        input();
        Arrays.sort(alpa);
        rec_func(1, alpa);
        System.out.println(sb.toString());
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