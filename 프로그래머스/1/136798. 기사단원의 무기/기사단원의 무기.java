import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        Map<Integer, Integer> divisorMap = getDivisors(number);
        
        int answer = 0;
        for(Integer key : divisorMap.keySet() ){
            int value = divisorMap.get(key);
            if (value <= limit) {
                answer += value;
            } else {
                answer += power;  
            }
        }
        
        return answer;
    }
    
    public static Map<Integer, Integer> getDivisors(int n) {
        Map<Integer, Integer> divisorMap = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            List<Integer> divisors = new ArrayList<>();
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    divisors.add(j);
                    if (j != i / j) {
                        divisors.add(i / j);
                    }
                }
            }
            divisorMap.put(i, divisors.size());
        }

        return divisorMap;
    }
}