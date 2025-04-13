import java.io.*;
import java.util.*;

public class onlyStack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String initial = br.readLine();
        int m = Integer.parseInt(br.readLine());

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (char ch : initial.toCharArray()) {
            left.push(ch);
        }
        
        for (int i = 0; i < m; i++) {
            String[] cmd = br.readLine().split(" ");
            switch (cmd[0]) {
                case "L":
                    if (!left.isEmpty()) right.push(left.pop());
                    break;
                case "D":
                    if (!right.isEmpty()) left.push(right.pop());
                    break;
                case "B":
                    if (!left.isEmpty()) left.pop();
                    break;
                case "P":
                    char c = cmd[1].charAt(0);
                    left.push(c);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();

        Stack<Character> temp = new Stack<>();
        while (!left.isEmpty()) {
            temp.push(left.pop());
        }

        while (!temp.isEmpty()) {
            sb.append(temp.pop());
        }

        while (!right.isEmpty()) {
            sb.append(right.pop());
        }

        System.out.println(sb);
    }
}
