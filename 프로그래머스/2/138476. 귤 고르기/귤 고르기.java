import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        List<Integer> valueCnt = new ArrayList<>(map.values());
        valueCnt.sort(Collections.reverseOrder());
        
        int sum = 0;
        for (Integer c : valueCnt) {
            sum += c;
            answer++;
            if (sum >= k) break;
        }
        
        return answer;
    }
}