import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Member implements Comparable<Member> {
        public int age, num;
        public String name;

        @Override
        public int compareTo(Member other) {
            if (age != other.age) return age - other.age;
            return num - other.num;
        }
    }

    static int N;
    static Member[] m;

    static void input() {
        N = scan.nextInt();
        m = new Member[N];
        for (int i = 0; i < N; i++) {
            m[i] = new Member();
            m[i].num = i;
            m[i].age = scan.nextInt();
            m[i].name = scan.next();
        }
    }

    static void pro() {
        Arrays.sort(m);
        for (Member mem : m) sb.append(mem.age).append(' ').append(mem.name).append('\n');
        System.out.print(sb);
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