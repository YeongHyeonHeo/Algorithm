import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static HashMap<Integer, Point> map = new HashMap<>();
    static int[][] A;

    static void init() {
        A = new int[283][283];
        A[1][1] = 1;
        map.put(1, new Point(1, 1));

        // 세로
        int k = 0;
        for (int i = 2; i <= 282; i++) {
            k++;
            A[i][1] = A[i-1][1] + k;
            map.put(A[i][1], new Point(1, i));
        }

        // 가로
        int a = 0;
        for (int i = 1; i <= 282; i++) {
            a++;
            int b = a;
            for (int j = 2; j <= 282; j++) {
                b++;
                A[i][j] = A[i][j-1] + b;
                map.put(A[i][j], new Point(j, i));
            }
        }
    }

    static int p, q;

    static void input() {
        p = scan.nextInt();
        q = scan.nextInt();
    }

    static void pro() {
        Point p1 = map.get(p);
        Point p2 = map.get(q);
        int nx = p1.x + p2.x;
        int ny = p1.y + p2.y;
        sb.append(A[ny][nx]).append('\n');
    }

    public static void main(String[] args) {
        init();
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