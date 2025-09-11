import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static String A, B;
    static int[] arr, arrClone;
    static int[] alp = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

    static void input() {
        A = scan.nextLine();
        B = scan.nextLine();
        arr = new int[A.length() * 2];
        arrClone = new int[A.length() * 2];
        int idx = 0;
        for (int i = 0; i < A.length(); i++) {
            arrClone[idx++] = alp[A.charAt(i)-'A'];
            arrClone[idx++] = alp[B.charAt(i)-'A'];
        }
    }

    static void pro() {
        for (int cnt = A.length()*2-1; cnt >=2 ; cnt--) {
            for (int i = 0; i < cnt; i++) {
                int num = arrClone[i] + arrClone[i+1];
                if (num >= 10) num %= 10;
                arr[i] = num;
            }
            for (int i = 0; i < cnt; i++) arrClone[i] = arr[i];
        }
        sb.append(arr[0]).append(arr[1]);
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