import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        for(int i=0; i<word.length(); i++){
            if(word.charAt(i)>='A' && word.charAt(i)<='Z'){
                System.out.print((char)(word.charAt(i) + 32));
            }
            else{
                System.out.print((char)(word.charAt(i) - 32));
            }
        }
    }
}
