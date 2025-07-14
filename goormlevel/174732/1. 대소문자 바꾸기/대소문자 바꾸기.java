import java.io.*;
import java.util.*;

class Main {
	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N;
	static char[] arr;

	static void input() {
		N = scan.nextInt();
		String S = scan.nextLine();
		arr = S.toCharArray();
	}

	static void pro() {
		for (int i = 0; i < arr.length; i++) {
			if ('a' <= arr[i] && arr[i] <= 'z') arr[i] = (char)('A' + (arr[i] - 'a'));
			else arr[i] = (char)('a' + (arr[i] - 'A'));
		}
		
		for (char c : arr) sb.append(c);
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