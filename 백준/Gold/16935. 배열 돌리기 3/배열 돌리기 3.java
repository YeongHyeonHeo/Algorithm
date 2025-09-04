import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, R;
    static int[][] A, AClone;
    static int[] rArr;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        R = scan.nextInt();
        A = new int[N][M];
        AClone = new int[N][M];
        for (int i = 0 ; i < N; i++) {
            for (int j = 0; j < M; j++) {
                A[i][j] = scan.nextInt();
                AClone[i][j] = A[i][j];
            }
        }
        rArr = new int[R];
        for (int i = 0; i < R; i++) rArr[i] = scan.nextInt();
    }

    static void exp1() {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) A[i][j] = AClone[A.length-i-1][j];
        }
        for (int i = 0; i < AClone.length; i++) {
            for (int j = 0; j < AClone[0].length; j++) AClone[i][j] = A[i][j];
        }
    }

    static void exp2() {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) A[i][j] = AClone[i][A[0].length-j-1];
        }
        for (int i = 0; i < AClone.length; i++) {
            for (int j = 0; j < AClone[0].length; j++) AClone[i][j] = A[i][j];
        }
    }

    static void exp3() {
        A = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) { // M
            for (int j = 0; j < A[0].length; j++) A[i][j] = AClone[A[0].length-j-1][i];
        }

        AClone = new int[A.length][A[0].length];
        for (int i = 0; i < AClone.length; i++) {
            for (int j = 0; j < AClone[0].length; j++) AClone[i][j] = A[i][j];
        }
    }

    static void exp4() {
        A = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) A[i][j] = AClone[j][A.length-i-1];
        }

        AClone = new int[A.length][A[0].length];
        for (int i = 0; i < AClone.length; i++) {
            for (int j = 0; j < AClone[0].length; j++) AClone[i][j] = A[i][j];
        }
    }

    static void exp5() { // 1 -> 2, 2 -> 3, 3 -> 4, 4 -> 1
        for (int i = 0; i < A.length/2; i++) {
            for (int j = 0; j < A[0].length/2; j++) A[i][j+A[0].length/2] = AClone[i][j];
        }
        for (int i = 0; i < A.length/2; i++) {
            for (int j = A[0].length/2; j < A[0].length; j++) A[i+A.length/2][j] = AClone[i][j];
        }
        for (int i = A.length/2; i < A.length; i++) {
            for (int j = A[0].length/2; j < A[0].length; j++) A[i][j-A[0].length/2] = AClone[i][j];
        }
        for (int i = A.length/2; i < A.length; i++) {
            for (int j = 0; j < A[0].length/2; j++) A[i-A.length/2][j] = AClone[i][j];
        }

        for (int i = 0; i < AClone.length; i++) {
            for (int j = 0; j < AClone[0].length; j++) AClone[i][j] = A[i][j];
        }
    }

    static void exp6() { //1 -> 4, 4 -> 3, 3 -> 2, 2 -> 1
        for (int i = 0; i < A.length/2; i++) {
            for (int j = 0; j < A[0].length/2; j++) A[i+A.length/2][j] = AClone[i][j];
        }
        for (int i = A.length/2; i < A.length; i++) {
            for (int j = 0; j < A[0].length/2; j++) A[i][j+A[0].length/2] = AClone[i][j];
        }
        for (int i = A.length/2; i < A.length; i++) {
            for (int j = A[0].length/2; j < A[0].length; j++) A[i-A.length/2][j] = AClone[i][j];
        }
        for (int i = 0; i < A.length/2; i++) {
            for (int j = A[0].length/2; j < A[0].length; j++) A[i][j-A[0].length/2] = AClone[i][j];
        }

        for (int i = 0; i < AClone.length; i++) {
            for (int j = 0; j < AClone[0].length; j++) AClone[i][j] = A[i][j];
        }
    }

    static void pro() {
        for (int i : rArr) {
            if (i == 1) exp1();
            else if (i == 2) exp2();
            else if (i == 3) exp3();
            else if (i == 4) exp4();
            else if (i == 5) exp5();
            else exp6();
        }

        for (int i = 0 ; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) sb.append(A[i][j]).append(' ');
            sb.append('\n');
        }

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
    }
}