import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, cnt;
    static String[] word;
    static int[] selected, alp;

    static void input() {
        N = scan.nextInt();
        word = new String[N + 1];
        for (int i = 1; i <= N; i++) word[i] = scan.nextLine();
        selected = new int[N + 1];
        cnt = 0;
    }

    static void rec_func(int k, int M) {
        if (k == M + 1) {
            alp = new int[26];
            for (int i = 1; i <= M; i++) {
                String s = word[selected[i]];
                for (int j = 0; j < s.length(); j++) {
                    alp[s.charAt(j)-'a']++;
                }
            }
            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (alp[i] == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) cnt++;
        } else {
            for (int cand = selected[k-1] + 1; cand <= N; cand++) {
                selected[k] = cand;
                rec_func(k + 1, M);
            }
        }
    }

    static void pro() {
        for (int i = 1; i <= N; i++) {
            rec_func(1, i);
        }
        sb.append(cnt).append('\n');
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