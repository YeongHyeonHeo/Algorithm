import java.io.*;
import java.util.*;

class Main {
	static FastReader scan = new FastReader();

	static int N, M;
	
	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();
	}

	static void pro() {
		double x = (N + M) / (double)N;
		System.out.println(String.format("%.2f", Math.floor((7/x) * 100) / 100.0));
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