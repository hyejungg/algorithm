import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        List<String> list = new ArrayList<>();

        for (String str : s) {
            Stack<Character> stack = new Stack<>();
            int count110 = 0;
            
            for (int i = 0; i < str.length(); i++) {
                stack.push(str.charAt(i));

                // 110 이 될 때까지 세개씩 꺼내가면서 찾기
                if (stack.size() >= 3) {
                    char first = stack.pop();
                    if (first != '0') {
                        stack.push(first);
                        continue;
                    }

                    char second = stack.pop();
                    if (second != '1') {
                        stack.push(second);
                        stack.push(first);
                        continue;
                    }

                    char third = stack.pop();
                    if(third != '1') {
                        stack.push(third);
                        stack.push(second);
                        stack.push(first);
                        continue;
                    }
                    count110++;
                }
            }

            int pos = stack.size();
            boolean flag = false;
            StringBuilder sb = new StringBuilder();
            
            // 0 을 발견할때까지 idx 조정
            while(!stack.isEmpty()) {
                char pop = stack.pop();
                if (!flag && pop == '1') {
                    pos--;
                }
                if (pop == '0') {
                    flag = true;
                }
                sb.insert(0, pop);
            }
            
            for (int i = 0; i < count110; i++) {
                sb.insert(pos, "110");
            }
            list.add(sb.toString());
        }

        return list.toArray(String[]::new);
    }
}
