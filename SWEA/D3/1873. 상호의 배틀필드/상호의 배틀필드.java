import java.io.*;
import java.util.*;

public class Solution {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int H, W, N;
    static char[][] A;
    static char[] command;

    static void input() {
        H = scan.nextInt();
        W = scan.nextInt();
        A = new char[H][W];
        for (int i = 0; i < H; i++){
            String str = scan.nextLine();
            for (int j = 0; j < W; j++) A[i][j] = str.charAt(j);
        }
        N = scan.nextInt();
        command = new char[N];
        String str = scan.nextLine();
        for (int i = 0; i < N; i++) command[i] = str.charAt(i);
    }

    static void pro() {
        // 전차 위치 찾기
        int x = 0, y = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (A[i][j] == '^' || A[i][j] == 'v'
                        || A[i][j] == '<' || A[i][j] == '>') {
                    x = i;
                    y = j;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (command[i] == 'U') {
                A[x][y] = '^';
                if (x-1 >= 0 && A[x-1][y] == '.') {
                    A[x-1][y] = A[x][y];
                    A[x][y] = '.';
                    x--;
                }
            } else if (command[i] == 'D') {
                A[x][y] = 'v';
                if (x+1 < H && A[x+1][y] == '.') {
                    A[x+1][y] = A[x][y];
                    A[x][y] = '.';
                    x++;
                }
            } else if (command[i] == 'L') {
                A[x][y] = '<';
                if (y-1 >= 0 && A[x][y-1] == '.') {
                    A[x][y-1] = A[x][y];
                    A[x][y] = '.';
                    y--;
                }
            } else if (command[i] == 'R') {
                A[x][y] = '>';
                if (y+1 < W && A[x][y+1] == '.') {
                    A[x][y+1] = A[x][y];
                    A[x][y] = '.';
                    y++;
                }
            } else {
                if (A[x][y] == '^') {
                    for (int j = x-1; j >= 0; j--) {
                        if (A[j][y] == '*') {
                            A[j][y] = '.';
                            break;
                        } else if (A[j][y] == '#') break;
                    }
                } else if (A[x][y] == 'v') {
                    for (int j = x+1; j < H; j++) {
                        if (A[j][y] == '*') {
                            A[j][y] = '.';
                            break;
                        } else if (A[j][y] == '#') break;
                    }
                } else if (A[x][y] == '<') {
                    for (int j = y-1; j >= 0; j--) {
                        if (A[x][j] == '*') {
                            A[x][j] = '.';
                            break;
                        } else if (A[x][j] == '#') break;
                    }
                } else {
                    for (int j = y+1; j < W; j++) {
                        if (A[x][j] == '*') {
                            A[x][j] = '.';
                            break;
                        } else if (A[x][j] == '#') break;
                    }
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) sb.append(A[i][j]);
            sb.append('\n');
        }
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