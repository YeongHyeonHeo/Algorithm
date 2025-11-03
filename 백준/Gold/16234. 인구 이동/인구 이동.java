import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();

    static int N, L, R;
    static int[][] A;
    static boolean[][] visit;
    static int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    static void input() {
        N = scan.nextInt();
        L = scan.nextInt();
        R = scan.nextInt();
        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) A[i][j] = scan.nextInt();
        }
        visit = new boolean[N][N];
    }

    // 인구 이동 발생 일수
    static int move() {
        int moveCount = 0;
        while (true) {
            boolean move = false;
            visit = new boolean[N][N]; // 방문 초기화
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 방문 안한 칸이면서 국경선 열 수 있으면 인구 이동 가능
                    if (!visit[i][j] && bfs(i, j)) move = true;
                }
            }
            if (!move) break; // 인구 이동 불가능하면 종료
            moveCount++;
        }
        return moveCount;
    }

    // 국경선 열기
    static boolean bfs(int x, int y) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        q.add(y);
        visit[x][y] = true; // 방문 처리 주의!
        int sum = A[x][y]; // 연합 인구
        int count = 1; // 연합 개수

        List<int[]> node = new ArrayList<>(); // 연합 좌표
        node.add(new int[] {x, y});

        while (!q.isEmpty()) {
            x = q.poll();
            y = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visit[nx][ny]) continue;

                int diff = Math.abs(A[x][y] - A[nx][ny]); // 두 나라의 인구 차이
                if (L <= diff && diff <= R) {
                    visit[nx][ny] = true;
                    q.add(nx);
                    q.add(ny);
                    sum += A[nx][ny];
                    count++;
                    node.add(new int[] {nx, ny});
                }
            }
        }

        if (count > 1) { // 인구 이동이 가능하면
            int avg = sum / count; // 각 칸의 인구수 재계산
            // 연합 좌표 node에 재계산된 인구수 넣기
            for (int[] n : node) {
                A[n[0]][n[1]] = avg;
            }
            return true;
        }
        return false;
    }

    static void pro() {
        System.out.println(move());
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