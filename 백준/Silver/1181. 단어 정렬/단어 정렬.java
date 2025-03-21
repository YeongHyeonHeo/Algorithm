import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Elem implements Comparable<Elem> {

        public String word;

        @Override
        public int compareTo(Elem other) {
            if (word.length() != other.word.length()) return word.length() - other.word.length();
            return word.compareTo(other.word);
        }
    }

    static void input() {
        N = scan.nextInt();
        words = new Elem[N];
        for (int i = 0; i < N; i++) {
            words[i] = new Elem();
            words[i].word = scan.nextLine();
        }
    }

    static int N;
    static Elem[] words;
    static String[] str;

    static void pro() {
        Arrays.sort(words);

        sb.append(words[0].word).append('\n');
        for (int i = 1; i < N; i++) {
            if (words[i].word.equals(words[i-1].word)) continue;
            sb.append(words[i].word).append('\n');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        pro();
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