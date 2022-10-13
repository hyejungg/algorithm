import java.util.*;

class Solution {
    boolean[] visit;
    ArrayList<String> answer;
    
    public String[] solution(String[][] tickets) {
        visit = new boolean[tickets.length + 1];
        answer = new ArrayList<>();
        
        dfs(tickets, "ICN", "ICN", 0);
        
        Collections.sort(answer); // 알파벳 순으로 오름차순 정렬
        
        return answer.get(0).split(" ");
    }
    
    public void dfs(String[][] tickets, String start, String str, int finishCnt) {
        // 목적지임? 그럼 나가
        if(finishCnt == tickets.length){
            answer.add(str);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if(start.equals(tickets[i][0]) && !visit[i]) {
                visit[i] = true;
                dfs(tickets, tickets[i][1], str + " " + tickets[i][1], finishCnt + 1);
                visit[i] = false;
            }
        }
    }
}