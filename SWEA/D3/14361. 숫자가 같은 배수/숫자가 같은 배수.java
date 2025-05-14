import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static String str;
    static int[] selected, used;
    static boolean flag;

    static void input() {
        N = scan.nextInt();
        str = Integer.toString(N);
        int len = str.length();
        selected = new int[len+1];
        used = new int[len+1];
        flag = false;
    }

    static void rec_fuc(int k) {
        if (k == str.length()+1) {
            String num = "";
            for (int i = 1; i <= str.length(); i++) {
                num += str.charAt(selected[i]-1);
            }
            int a = Integer.parseInt(num);
            if (a > N && a % N == 0) flag = true;
        } else {
            for (int cand = 1; cand <= str.length(); cand++) {
                if (flag) return;
                if (used[cand] == 1) continue;
                selected[k] = cand;
                used[cand] = 1;
                rec_fuc(k+1);
                used[cand] = 0;
            }
        }
    }

    static void pro() {
        rec_fuc(1);
        if (flag) sb.append("possible\n");
        else sb.append("impossible\n");
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