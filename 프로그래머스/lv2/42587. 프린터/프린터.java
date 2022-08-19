import java.util.*;

class Solution {
    class Print {
        int idx;
        int priority;

        public Print(int idx, int priority){
            this.idx = idx;
            this.priority = priority;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Print> q = new LinkedList<>(); // {idx, 중요도} 형태로 저장
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순

        for(int i = 0; i < priorities.length; i++){
            q.add(new Print(i, priorities[i]));
            pq.add(priorities[i]);
        }

        while(!pq.isEmpty()){
            Print now = q.poll();

            if(now.priority != pq.peek()){
                q.add(now); //현재 중요도가 높지않아서 맨 뒤로 넣음
            }else{
                answer++;
                pq.poll();
                if(now.idx == location){
                    break;
                }
            }
        }
        return answer;
    }
}