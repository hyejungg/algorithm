import java.util.*;

class Solution {
    int answer = 0;
    public int getScovile(int n1, int n2) {
        ++answer;
        return n1 + (n2 * 2);
    }
    
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 오름차순 우선순위 큐

        Arrays.stream(scoville).forEach(pq::add); // 큐에 넣어

        while (pq.size() >= 2 && pq.peek() <= K) {
            int peek1 = pq.peek();
            pq.remove();
            int peek2 = pq.peek();
            pq.remove();

            pq.add(getScovile(peek1, peek2));
        }

        return (pq.peek() < K) ? -1 : answer;
    }
}