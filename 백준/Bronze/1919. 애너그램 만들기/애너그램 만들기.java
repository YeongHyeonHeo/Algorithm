import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] word = sc.next().toCharArray();
        char[] word2 = sc.next().toCharArray();

        for(int i = 0; i < word.length; i++){
            for(int j = 0; j < word2.length; j++){
                if(word[i] == word2[j]){
                    word[i] = ' ';
                    word2[j] = ' ';
                }
            }
        }

        int sum = 0;
        for(int i : word){
            if(i != ' '){
                sum += 1;
            }
        }
        for(int i : word2){
            if(i != ' '){
                sum += 1;
            }
        }
        System.out.println(sum);
    }
}
