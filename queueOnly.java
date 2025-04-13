import java.io.*;
import java.util.*;

public class EditorWithQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기 문자열 입력
        String initial = br.readLine();
        int m = Integer.parseInt(br.readLine()); // 명령어 개수

        // 양쪽 덱 (Deque 사용 - 큐처럼 동작하지만 스택 기능도 있음)
        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();

        for (char ch : initial.toCharArray()) {
            left.addLast(ch); // 처음엔 모두 왼쪽 덱에
        }

        for (int i = 0; i < m; i++) {
            String[] cmd = br.readLine().split(" ");
            switch (cmd[0]) {
                case "L": // 왼쪽으로 커서 이동
                    if (!left.isEmpty()) right.addFirst(left.pollLast());
                    break;
                case "D": // 오른쪽으로 커서 이동
                    if (!right.isEmpty()) left.addLast(right.pollFirst());
                    break;
                case "B": // 백스페이스
                    if (!left.isEmpty()) left.pollLast();
                    break;
                case "P": // 문자 삽입
                    left.addLast(cmd[1].charAt(0));
                    break;
            }
        }

        // 최종 결과 출력
        StringBuilder sb = new StringBuilder();
        for (char c : left) sb.append(c);
        for (char c : right) sb.append(c);

        System.out.println(sb);
    }
}
