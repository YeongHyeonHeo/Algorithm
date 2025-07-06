import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Person implements Comparable<Person> {
        public int num, height, weight, ans;

        public int compareTo(Person other) {
            if (height != other.height) return other.height - height;
            return other.weight - weight;
        }
    }

    static int N;
    static Person[] p;

    static void input() {
        N = scan.nextInt();
        p = new Person[N];
        for (int i = 0; i < N; i++) {
            p[i] = new Person();
            p[i].num = i;
            p[i].height = scan.nextInt();
            p[i].weight = scan.nextInt();
        }
    }

    static void pro() {
        Arrays.sort(p);
        p[0].ans = 1;
        for (int i = 1; i < N; i++) {
            int cnt = 1;
            for (int j = 0; j < i; j++) {
                if (p[i].weight < p[j].weight && p[i].height != p[j].height) cnt++;
            }
            p[i].ans = cnt;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (p[j].num == i) sb.append(p[j].ans).append(' ');
            }
        }
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