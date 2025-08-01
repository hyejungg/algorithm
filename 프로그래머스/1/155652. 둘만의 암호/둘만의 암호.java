import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        Set<Character> skipSet = new HashSet<>();
        for (char c: skip.toCharArray()) {
            skipSet.add(c);
        }
        
        for(char c : s.toCharArray()) {
            int count = 0;
            while(count < index) {
                if (c == 'z') {
                    c = 'a';
                } else {
                    c++;
                }
                if (!skipSet.contains(c)) {
                    count++;
                }
            }
            answer.append(c);
        }
        return answer.toString();
    }
}