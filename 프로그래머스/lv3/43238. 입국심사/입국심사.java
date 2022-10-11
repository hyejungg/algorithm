import java.util.*; 

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        // start, end를 시간으로 잡음
        long start = 1;
        long end = (long) n * times[times.length - 1]; // 제일 느리게 걸리는 시간 (long)으로 타입 변환 안해주면 실패!
        while (start <= end) {
            long mid = (start + end) / 2;
            
            long sum = 0; // 시간 안에 처리 가능한 사람 합
            for (int i = 0; i < times.length; i++) {
                sum += mid / times[i];
            }
            // 처리 가능한 사람 수가 처리해야 하는 사람보다 많으면
            if (sum >= n) {
                end = mid - 1; // 시간 줄여
                answer = mid;
            } else {
                start = mid + 1; // 시간 늘려
            }
        }
        return answer;
    }
}