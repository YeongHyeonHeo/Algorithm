import java.util.*;
import java.io.*;

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
        int ans = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            if (arr[i-1] >= arr[i]) {
                if (list.size() > 0) ans = Math.max(ans, list.get(list.size()-1)-list.get(0));
                list = new ArrayList<>();
                continue;
            }
            list.add(arr[i-1]);
            list.add(arr[i]);
        }
        if (list.size() > 0) ans = Math.max(ans, list.get(list.size()-1)-list.get(0));
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