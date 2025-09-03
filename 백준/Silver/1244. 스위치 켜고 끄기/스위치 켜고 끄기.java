import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int switchCnt, student, gender, num;
    static int[] arr;

    static void input() {
        switchCnt = scan.nextInt();
        arr = new int[switchCnt];
        for (int i = 0; i < switchCnt; i++) arr[i] = scan.nextInt();
        student = scan.nextInt();
    }

    static void doSwitch(int num) {
        if (arr[num] == 0) arr[num] = 1;
        else arr[num] = 0;
    }

    static void pro() {
        while (student-- > 0) {
            gender = scan.nextInt();
            num = scan.nextInt();

            if (gender == 1) {
                for (int i = 1; i <= switchCnt; i++) {
                    if (i % num == 0) doSwitch(i - 1);
                }
            } else {
                doSwitch(num - 1);
                int left = num - 1;
                int right = num + 1;
                while (true) {
                    if (left-1 < 0 || right-1 > switchCnt-1) break;
                    if (arr[left-1] != arr[right-1]) break;
                    doSwitch(left-1);
                    doSwitch(right-1);
                    left--; right++;
                }
            }
        }

        // 한 줄에 20개씩 출력
        int cnt = 0;
        for (int i : arr) {
            sb.append(i).append(' ');
            cnt++;
            if (cnt == 20) {
                sb.append('\n');
                cnt = 0;
            }
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
    }
}