import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();

    static int N; // 후보 수
    static int[] arr; // 각 후보의 투표 수

    static void input() {
        N = scan.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = scan.nextInt();
    }

    static void pro() {
        // 높은 숫자 먼저 나오는 우선순위 큐 사용
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // arr[0] : 기호 1번(다솜) 투표 수
        // arr[0] 제외하고 pq에 넣기
        for (int i = 1; i < N; i++) pq.add(arr[i]);

        int ans = 0; // 매수해야 하는 사람의 최솟값
        // 기호 1번 투표 수가 가장 많을 때까지 반복
        while (true) {
            // 후보가 1명이라면 진행 X
            if (pq.isEmpty()) break;

            int max = pq.poll(); // 기호 1번 제외한 가장 많은 투표 수
            if (max < arr[0]) break;
            else {
                // 매수 후 다시 pq에 넣기
                pq.add(--max);
                arr[0]++;
                ans++;
            }
        }

        System.out.println(ans);
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