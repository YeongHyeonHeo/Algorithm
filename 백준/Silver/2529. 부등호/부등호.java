import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        signs = new String[N+1];
        for (int i = 1; i <= N; i++) signs[i] = scan.next();
        nums = new int[11];
        for (int i = 1; i <= 10; i++) nums[i] = i - 1;
        selected = new int[N+2];
        used = new int[11];
    }

    static int N;
    static int[] nums, selected, used;
    static String[] signs;
    static ArrayList<int[]> list = new ArrayList<int[]>();

    static boolean valid(int[] selected, String[] signs) {
        for (int i = 1; i <= N; i++) {
            if (signs[i].equals("<")) {
                if (!(selected[i] < selected[i+1])) return false;
            }
            if (signs[i].equals(">")) {
                if (!(selected[i] > selected[i+1])) return false;
            }
        }
        return true;
    }

    static void rec_func(int k) {
        if (k == N + 2) {
            if (valid(selected, signs)) {
                list.add(Arrays.copyOf(selected, selected.length));
            }
        } else {
            for (int cand = 1; cand <= 10; cand++) {
                if (used[cand] == 1) continue;
                selected[k] = nums[cand]; used[cand] = 1;
                rec_func(k + 1);
                selected[k] = 0; used[cand] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1);
        for (int i = 1; i <= N + 1; i++) {
            sb.append(list.get(list.size()-1)[i]);
        }
        sb.append('\n');
        for (int i = 1; i <= N + 1; i++) {
            sb.append(list.get(0)[i]);
        }
        System.out.println(sb.toString());
    }

    static class FastReader {
        BufferedReader bf;
        StringTokenizer st;

        public FastReader() {
            bf = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(bf.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = bf.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}