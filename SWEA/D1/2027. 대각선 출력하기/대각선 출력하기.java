import java.io.*;
import java.util.*;

public class Solution {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == j) sb.append('#');
                else sb.append('+');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}