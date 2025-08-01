import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playerIdx = new HashMap<>();
        String[] answer = new String[players.length];
        for (int i = 0; i < players.length; i++) {
            playerIdx.put(players[i], i);
            answer[i] = players[i];
        }
        
        for (String now : callings) {
            int idx = playerIdx.get(now);
            if (idx == 0) continue; 
            
            String swapPlayerName = answer[idx - 1]; // 앞에 있는 선수
            String tempNowName = answer[idx]; 
            
            
            answer[idx - 1] = tempNowName;
            answer[idx] = swapPlayerName;
            
            
            playerIdx.put(tempNowName, idx - 1);
            playerIdx.put(swapPlayerName, idx);
        }
        
        return answer;
    }
}