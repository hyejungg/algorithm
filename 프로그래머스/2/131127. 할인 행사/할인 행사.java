import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        for (int i = 0; i < discount.length; i++) {
            String[] sliced = Arrays.copyOfRange(discount, i, i + 10);
            
            Map<String, Integer> discountMap = new HashMap<>();
            for (int j = 0; j < sliced.length; j++) {
                discountMap.put(sliced[j], discountMap.getOrDefault(sliced[j], 0) + 1);
            }
            
        
            int totalCount = 0;
            for(String key : wantMap.keySet() ){
                if (!discountMap.containsKey(key)) {
                    continue;
                } else {
                    int discountCnt = discountMap.get(key);
                    int wantCnt = wantMap.get(key);
                    
                    if (discountCnt >= wantCnt) {
                        totalCount++;
                    }
                }
            }
            
            if (totalCount == want.length) {
                answer++;
            }
        }
        
        return answer;
    }
}