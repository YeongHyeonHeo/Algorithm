import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static String A, B;
    static int[] num1, num2;

    static void input() {
        A = scan.next();
        B = scan.next();
        num1 = new int[A.length()];
        num2 = new int[B.length()];
        for (int i = 0; i < A.length(); i++) num1[i] = A.charAt(i) - '0';
        for (int i = 0; i < B.length(); i++) num2[i] = B.charAt(i) - '0';
    }

    static void pro() {
        int min = Math.min(A.length(), B.length());
        boolean AisL = A.length() > B.length();
        boolean BisL = B.length() > A.length();
        int a = A.length()-1, b = B.length()-1;
        if (AisL) {
            for (int i = 0; i < min; i++) {
                if (num1[a] + num2[b] <= 9) num1[a] += num2[b];
                else {
                    num1[a] = (num1[a] + num2[b]) % 10;
                    num1[a-1]++;
                }
                a--;
                b--;
            }
            while (a >= 1) {
                if (num1[a] == 10) {
                    num1[a] = 0;
                    num1[--a]++;
                }
                else break;
            }
            for (int n : num1) sb.append(n);
        }
        else if (BisL) {
            for (int i = 0; i < min; i++) {
                if (num1[a] + num2[b] <= 9) num2[b] += num1[a];
                else {
                    num2[b] = (num1[a] + num2[b]) % 10;
                    num2[b-1]++;
                }
                a--;
                b--;
            }
            while (b >= 1) {
                if (num2[b] == 10) {
                    num2[b] = 0;
                    num2[--b]++;
                }
                else break;
            }
            for (int n : num2) sb.append(n);
        }
        else {
            for (int i = min-1; i >= 0; i--) {
                if (num1[i] + num2[i] <= 9) num1[i] += num2[i];
                else {
                    if (i != 0) {
                        num1[i] = (num1[i] + num2[i]) % 10;
                        num2[i-1]++;
                    }
                    else num1[i] += num2[i];
                }
            }
            for (int n : num1) sb.append(n);
        }
        sb.append('\n');
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