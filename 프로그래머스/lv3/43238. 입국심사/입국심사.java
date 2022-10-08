import java.util.*; 

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        long start = 1;
        long end = (long) n * times[times.length - 1];
        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;
            for (int i = 0; i < times.length; i++) {
                sum += mid / times[i];
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