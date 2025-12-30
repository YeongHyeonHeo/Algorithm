import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();

    static int N, M, ans;
    static int[] find;

    static void input() {
        N = scan.nextInt(); // 큐의 크기
        M = scan.nextInt(); // 뽑아내려고 하는 수의 개수
        find = new int[M];
        for (int i = 0; i < M; i++) find[i] = scan.nextInt();
    }

    static void pro() {
        // 1 ~ N 까지 덱에 넣기
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) deque.add(i);

        // find 배열(뽑아낼 수의 위치) 하나씩 순회하면서 계산
        for (int num : find) {
            int idx = deque.indexOf(num);
            while (idx != 0) {
                if (idx <= deque.size() / 2) deque.addLast(deque.pollFirst());
                else deque.addFirst(deque.pollLast());
                ans++;
                idx = deque.indexOf(num);
            }
            deque.pollFirst();
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