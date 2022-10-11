import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        // 1. 스택을 이용해서 괄호 확인
        // 2. 해당 round가 종료되면 재정의
        // ** 답이 엥싶으면 제발 찍어봐 혜정아
        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            boolean right = true;
            for (int j = 0; j < s.length(); j++) {
                // System.out.println("now s : " + s);
                if (s.charAt(j) == '(' || s.charAt(j) == '[' || s.charAt(j) == '{')
                    stack.add(s.charAt(j));
                else {
                    if(stack.isEmpty()){
                        right = false;
                        break;
                    }
                    else {
                        if (s.charAt(j) == ')' && stack.peek() == '(') {
                            stack.pop();
                        } else if (s.charAt(j) == ']' && stack.peek() == '[') {
                            stack.pop();
                        } else if (s.charAt(j) == '}' && stack.peek() == '{') {
                            stack.pop();
                        }
                    }
                }
            }

            if (stack.isEmpty() && right) ++answer;

            // 문자열 재정의
            Character front = s.charAt(0);
            s = s.substring(1) + front;
        }

        return answer;
    }
}