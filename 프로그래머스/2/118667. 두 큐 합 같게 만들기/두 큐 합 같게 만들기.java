import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int N = queue1.length;
        
        Queue<Integer> q1 = new LinkedList<>();
        long q1Sum = 0;
        Queue<Integer> q2 = new LinkedList<>();
        long q2Sum = 0;
        
        for (int i = 0; i < N; i++) {
            q1.offer(queue1[i]);
            q1Sum += queue1[i];
            
            q2.offer(queue2[i]);
            q2Sum += queue2[i];
        }
        
        if (q1Sum == q2Sum) return 0;
        
        int answer = 0;
        while (answer <= N*2+1 && !q1.isEmpty() && !q2.isEmpty()) {
            if (q1Sum > q2Sum) {
                int a = q1.poll();
                q2.offer(a);
                q1Sum -= a;
                q2Sum += a;
                answer++;
            } else {
                int a = q2.poll();
                q1.offer(a);
                q2Sum -= a;
                q1Sum += a;
                answer++;
            }
            
            if (q1Sum == q2Sum) return answer;
        }
        
        return -1;
    }
}