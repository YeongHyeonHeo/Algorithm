import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static String[] A, code;
    static String[] info = {"0001101", "0011001", "0010011", "0111101", "0100011",
            "0110001", "0101111", "0111011", "0110111", "0001011"};

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new String[N];
        code = new String[8];
        for (int i = 0; i < N; i++) A[i] = scan.nextLine();
    }

    static void pro() {
        int idxI = 0, idxJ = 0;
        for (int i = 0; i < N; i++) {
            boolean flag = false;
            for (int j = M-1; j >= 0; j--) {
                if (A[i].charAt(j) == '1') {
                    idxI = i;
                    idxJ = j;
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }

        int k = 0;
        for (int i = idxJ-55; i < idxJ; i+=7) {
            String str = "";
            for (int j = 0; j < 7; j++) str += A[idxI].charAt(i+j);
            code[k] = str;
            k++;
        }

        int[] ans = new int[8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++) {
                if (code[i].equals(info[j])) {
                    ans[i] = j;
                    break;
                }
            }
        }

        int sum= 0;
        for (int i = 1; i <= 8; i++) {
            if (i % 2 == 1) sum += ans[i-1] * 3;
            else sum += ans[i-1];
        }

        if (sum % 10 == 0) {
            int s = 0;
            for (int i = 0; i < 8; i++) s += ans[i];
            sb.append(s).append('\n');
        }
        else sb.append(0).append('\n');
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