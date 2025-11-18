import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, cnt;
    static String[] arr;
    static boolean[][] visited;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        arr = new String[N];
        for (int i = 0; i < N; i++) arr[i] = scan.nextLine();
        visited = new boolean[N][M];
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (arr[nx].charAt(ny) == 'X') continue;
            if (visited[nx][ny]) continue;
            if (arr[nx].charAt(ny) == 'P') cnt++;
            dfs(nx, ny);
        }
    }

    static void pro() {
        // 도연이 위치(I) 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i].charAt(j) == 'I') dfs(i, j); // I 위치부터 dfs 탐색 시작 
            }
        }

        if (cnt == 0) sb.append("TT"); // 아무도 만나지 못한 경우
        else sb.append(cnt); // 만날 수 있는 사람의 수 출력
        System.out.print(sb);
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    public static class FastReader {
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