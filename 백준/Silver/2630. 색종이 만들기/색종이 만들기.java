import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();

    static int N, white, blue;
    static int[][] arr;

    static void input() {
        N = scan.nextInt();
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) arr[i][j] = scan.nextInt();
        }
    }

    static void rec_func(int row, int col, int size) {
        if (check(row, col, size)) {
            if (arr[row][col] == 0) white++;
            else blue++;
            return;
        }

        int newSize = size / 2;
        rec_func(row, col, newSize);
        rec_func(row + newSize, col, newSize);
        rec_func(row, col + newSize, newSize);
        rec_func(row + newSize, col + newSize, newSize);
    }

    static boolean check(int row, int col, int size) {
        int color = arr[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] != color) return false;
            }
        }

        return true;
    }

    static void pro() {
        rec_func(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
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