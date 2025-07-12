import java.io.*;
import java.util.*;

class Main {
	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int X, Y, N;
	
	static void input() {
		X = scan.nextInt();
		Y = scan.nextInt();
		N = scan.nextInt();
	}

	static void pro() {
		int sum = Math.abs(X) + Math.abs(Y);
		if (sum > N) sb.append("NO\n");
		else if (sum % 2 == N % 2) sb.append("YES\n");
		else sb.append("NO\n");
	}
	
	public static void main(String[] args) throws Exception {
		int T = scan.nextInt();
		while (T-- > 0) {
			input();