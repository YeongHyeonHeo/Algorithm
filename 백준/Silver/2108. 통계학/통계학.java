import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] arr;

    static void input() {
        N = scan.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = scan.nextInt();
    }

    static void pro() {
        Arrays.sort(arr);
        int center = arr[N/2]; // 중앙값
        int range = arr[N-1] - arr[0]; // 범위
        int avg = 0, most = 0;

        // 산술평균
        int sum = 0;
        for (int num : arr) sum += num;
        avg = Math.round(sum / (float)N);

        // 최빈값
        int[] cnt = new int[8001];
        for (int num : arr) {
            if (num < 0) cnt[4000-num]++;
            else cnt[num]++;
        }
        int maxCnt = 0;
        for (int i = 4001; i <= 8000; i++) {
            if (cnt[i] > maxCnt) {
                maxCnt = cnt[i];
                most = -(i - 4000);
            }
        }
        for (int i = 0; i <= 4000; i++) {
            if (cnt[i] > maxCnt) {
                maxCnt = cnt[i];
                most = i;
            }
        }
        int check = 0;
        for (int i = 8000; i > 4000; i--) {
            if (check == 2) break;
            if (cnt[i] == maxCnt) {
                check++;
                most = -(i - 4000);
            }
        }
        for (int i = 0; i <= 4000; i++) {
            if (check == 2) break;
            if (cnt[i] == maxCnt) {
                check++;
                most = i;
            }
        }

        sb.append(avg).append('\n').append(center).append('\n').append(most).append('\n').append(range);
        System.out.println(sb);
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