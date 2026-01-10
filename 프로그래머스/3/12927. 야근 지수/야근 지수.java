import java.util.*;

// 최소 제곱합 == 수가 균등할 수록 이득
class Solution {
    public long solution(int n, int[] works) {
        long sum = Arrays.stream(works).sum();
        if (sum <= n) {
            return 0;
        }
        
        // 내림차순 pq (현재 최대 값 저장)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int w : works) {
            pq.add(w); // 모든 값을 저장
        }
        
        List<Integer> result = new ArrayList<>();
        while (pq.size() != 0) {
            int maxValue = pq.poll();
            if (n > 0) {
                maxValue--;
                n--;
                pq.add(maxValue);   
            } else {
                result.add(maxValue);
            }
        }
        
        return result.stream().mapToLong(x -> (long) x * x).sum();
    }
}