import java.util.*;

class Solution {
    private boolean[] visit;
    public int solution(int n, int[][] computers) {
        int answer = 0;

        visit = new boolean[n];


        for (int i = 0; i < computers.length; i++){
            if(!visit[i]) {
                bfs(i, computers);
                answer++;
            }
        }

        return answer;
    }

    public void bfs(int start, int[][] computers) {
        visit[start] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()) {
            int front = q.poll();

            for(int i = 0; i < computers[start].length; i++) {
                if(!visit[i] && computers[front][i] == 1){
                    visit[i] = true;
                    q.add(i);
                }
            }
        }
    }
}