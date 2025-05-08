import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K;
    static double[] scoreSum;
    static String[] score = {"D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+"};

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        scoreSum = new double[N];
        for (int i = 0; i < N; i++) {
            int mid = scan.nextInt();
            int fin = scan.nextInt();
            int work = scan.nextInt();
            scoreSum[i] = (mid*0.35) + (fin*0.45) + (work*0.2);
        }
    }

    static void pro() {
        double goal = scoreSum[K-1];
        Arrays.sort(scoreSum);
        for (int i = 0; i < N; i++) {
            if (scoreSum[i] == goal) sb.append(score[i/(N/10)]).append('\n');
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