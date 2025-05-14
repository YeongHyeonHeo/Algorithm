import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static char[][] A;
    static int[][] dir = {{0, 1}, {1, 0}, {1, 1}, {1, -1}};
    static boolean find;

    static void input() {
        N = scan.nextInt();
        A = new char[N][N];
        find = false;
        for (int i = 0; i < N; i++) {
            String str = scan.nextLine();
            for (int j = 0; j < N; j++) A[i][j] = str.charAt(j);
        }
    }

    static int dfs(int i, int j, int d, int count) {
        int nx = i + dir[d][0];
        int ny = j + dir[d][1];

        if (nx < N && ny < N && nx > -1 && ny > -1 && A[nx][ny] == 'o') {
            return dfs(nx, ny, d, count+1);
        }

        return count;
    }

    static void pro() {
        for (int i = 0; i < N && !find; i++) {
            for (int j = 0; j < N && !find; j++) {
                if (A[i][j] == 'o') {
                    for (int k = 0; k < 4; k++) {
                        int cnt = dfs(i, j, k, 1);
                        if (cnt >= 5) {
                            find = true;
                            break;
                        }
                    }
                }
            }
        }
        sb.append(find ? "YES" : "NO").append('\n');
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