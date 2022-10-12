import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times); // 오름차순 정렬
        
        long start = 1, end = (long) n * times[times.length - 1];
        
        while (start <= end) {
            long mid = (start + end) / 2;
            
            long sum = 0;
            for (Integer t : times) {
                sum += mid / t;
            }
            
            if (sum >= n) {
                end = mid - 1;
                answer = mid;
            } else {
                start = mid + 1;
            }
        }
        
        return answer;
    }
}