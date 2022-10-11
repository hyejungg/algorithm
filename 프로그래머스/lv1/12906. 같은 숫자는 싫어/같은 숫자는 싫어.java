import java.util.*;

public class Solution {
    // stack으로 풀기
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();

        for (int a : arr) {
            if(stack.empty()) stack.add(a);
            if(stack.peek() != a) stack.add(a);
        }

        List<Integer> answer = new ArrayList<>();
        while (!stack.isEmpty()) {
            answer.add(stack.pop());
        }

        Collections.reverse(answer);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}