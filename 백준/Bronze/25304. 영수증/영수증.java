import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int N = sc.nextInt();

        int total = 0;
        for(int i = 0; i < N; i++){
            total += (sc.nextInt() * sc.nextInt());
        }

        System.out.println(X == total ? "Yes" : "No");
    }
}
