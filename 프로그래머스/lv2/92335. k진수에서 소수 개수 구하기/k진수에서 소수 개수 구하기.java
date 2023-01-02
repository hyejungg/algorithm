import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        // 1. k진수 형태로 n을 바꾼다.
        String number = Integer.toString(n, k);

        // 2. 조건에 맞는 수 추출해서 배열로 넣는다.
        List<String> numbers = Arrays.asList(number.split("0"));
        
        // 3. 각 list를 돌면서 소수인지 확인 -> 소수면 answer++
        for (String num : numbers) {
            if (num.isEmpty()) continue;
            if (isPrime(Long.parseLong(num))) answer++;
        }
        
        return answer;
    }
    
    public boolean isPrime(long num) {
        if (num == 1) return false;
        if (num == 2) return true;
        
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}