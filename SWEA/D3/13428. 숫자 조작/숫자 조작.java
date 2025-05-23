import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static String str;
    static int[] num, selected;
    static int min, max;

    static void input() {
        str = scan.nextLine();
        num = new int[str.length()+1];
        for (int i = 1; i < num.length; i++) num[i] = str.charAt(i-1) - '0';
        selected = new int[3];
    }

    static void rec_func(int k) {
        if (k == 3) {
            int temp = num[selected[1]];
            num[selected[1]] = num[selected[2]];
            num[selected[2]] = temp;
            if (!(num[1] == 0)) {
                String s = "";
                for (int i = 1; i < num.length; i++) s += Integer.toString(num[i]);
                min = Math.min(min, Integer.parseInt(s));
                max = Math.max(max, Integer.parseInt(s));

            }
            // 원상복구
            temp = num[selected[1]];
            num[selected[1]] = num[selected[2]];
            num[selected[2]] = temp;
        } else {
            for (int cand = selected[k-1] + 1; cand < num.length; cand++) {
                selected[k] = cand;
                rec_func(k+1);
            }
        }
    }

    static void pro() {
        min = Integer.parseInt(str);
        max = Integer.parseInt(str);
        rec_func(1);
        sb.append(min).append(' ').append(max).append('\n');
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