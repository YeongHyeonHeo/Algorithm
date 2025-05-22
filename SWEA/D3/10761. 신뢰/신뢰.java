import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static String[] A;

    static void input() {
        N = scan.nextInt();
        A = new String[N*2];
        for (int i = 0; i < N*2; i++) A[i] = scan.next();
    }

    static void pro() {
        int time = 0, orangeTime = 0, blueTime = 0, orangePos = 1, bluePos = 1;

        for (int i = 0; i < N*2; i+=2) {
            String robot = A[i];
            int button = Integer.parseInt(A[i+1]);
            if (robot.equals("O")) {
                int moveTime = Math.abs(button - orangePos) + 1;
                orangeTime += moveTime;
                if (orangeTime > time) time = orangeTime;
                else {
                    time++;
                    orangeTime = time;
                }
                orangePos = button;
            } else {
                int moveTime = Math.abs(button - bluePos) + 1;
                blueTime += moveTime;
                if (blueTime > time) time = blueTime;
                else {
                    time++;
                    blueTime = time;
                }
                bluePos = button;
            }
        }
        sb.append(time).append('\n');
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