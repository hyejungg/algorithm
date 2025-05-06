import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 오름차순 우선순위 큐

        for (int i = 0; i < score.length; i++) {
            pq.offer(score[i]);
            if (pq.size() > k) {
                pq.poll(); // 가장 낮은 점수 제거
            }
            answer[i] = pq.peek(); // 현재 명예의 전당 점수
        }

        return answer;
    }
}