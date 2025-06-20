import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int[] arr;

    static void input() {
        arr = new int[8];
        for (int i = 0; i < 8; i++) arr[i] = scan.nextInt();
    }

    static void pro() {
        boolean flag = true;
        for (int i = 0; i <= 6; i++) {
            if (Math.abs(arr[i] - arr[i+1]) != 1) {
                flag = false;
                break;
            }
        }
        if (flag && arr[0] == 1) sb.append("ascending");
        else if (flag && arr[0] == 8) sb.append("descending");
        else sb.append("mixed");
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