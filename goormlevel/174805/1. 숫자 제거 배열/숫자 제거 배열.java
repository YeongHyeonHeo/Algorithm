import java.io.*;
import java.util.*;

class Main {
	static FastReader scan = new FastReader();

	static int N;
	static String K;
	
	static void input() {
		N = scan.nextInt();
		K = scan.next();
	}

	static void pro() {
		int cnt = 0;
		while (N-- > 0) {
			String s = scan.next();
			if (!s.contains(K)) cnt++;
		}
		System.out.println(cnt);
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