import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < progresses.length; i++){
            int job = 100 - progresses[i]; // 남은 진척도

            if(job % speeds[i] != 0){
                q.add(job / speeds[i] + 1);
            } else {
                q.add(job / speeds[i]);
            }
        }

        while (!q.isEmpty()) {
            int day = 1;
            int now = q.poll();

            while (true) {
                if (!q.isEmpty() && now >= q.peek()) {
                    ++day;
                    q.poll();
                } else {
                    answer.add(day);
                    break;
                }
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}