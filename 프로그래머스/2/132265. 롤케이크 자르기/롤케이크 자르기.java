import java.util.*;

class Solution {
    public int solution(int[] topping) {
        Set<Integer> p1 = new HashSet<>();
        Map<Integer, Integer> p2 = new HashMap<>();
        
        int answer = 0;
        
        // 토핑별 개수
        for (int t : topping) {
            p2.put(t, p2.getOrDefault(t, 0) + 1);
        }
        
        
        for(int i = 0; i < topping.length; i++) {
            int t = topping[i];
            p1.add(t);
            p2.put(t, p2.get(t) - 1);
            if (p2.get(t) == 0) {
                p2.remove(t);
            }

            if (p1.size() == p2.size()) {
                answer++;
            }
            
        }
        return answer;
    }
}