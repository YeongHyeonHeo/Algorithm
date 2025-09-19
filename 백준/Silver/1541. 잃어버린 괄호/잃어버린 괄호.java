import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();

    static String s;
    static String[] plus;
    static int[] nums;

    static void input() {
        s = scan.next();
        plus = s.split("-");
        nums = new int[plus.length];
    }

    static void pro() {
        for (int i = 0; i < plus.length; i++) {
            String[] arr = plus[i].split("\\+");
            int temp = 0;
            for (String num : arr) temp += Integer.parseInt(num);
            nums[i] = temp;
        }

        // 뺄셈
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) ans -= nums[i];
        System.out.println(ans);
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
            return st.nextToken();
        }
    }
}