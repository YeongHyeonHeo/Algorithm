import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K;
    static int[][] scoreSum;
    static String[] score = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        scoreSum = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            sum += (scan.nextInt()) * 35/100;
            sum += (scan.nextInt()) * 45/100;
            sum += (scan.nextInt()) * 20/100;
            scoreSum[i][0] = sum;
            scoreSum[i][1] = i;
        }
    }

    static void pro() {
        Arrays.sort(scoreSum, 1, N + 1, Comparator.comparingInt((int[] o) -> o[0]).reversed());

        int idx = N/10;
        int cnt = -1;
        for (int i = 1; i <= N; i+=idx) {
            cnt++;
            for (int j = 0; j < idx; j++) scoreSum[i+j][0] = cnt;
        }

        for (int i = 1; i <= N; i++) {
            if (scoreSum[i][1] == K) sb.append(score[scoreSum[i][0]]).append('\n');
        }
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(' ');
            input();
            pro();
        }
        System.out.println(sb);
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