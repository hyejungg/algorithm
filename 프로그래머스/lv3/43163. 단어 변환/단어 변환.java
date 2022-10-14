import java.util.*;

class Solution {
    int answer = 0;
    boolean visit[];
    public int solution(String begin, String target, String[] words) {
        visit = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer;
    }
    
    public void dfs(String begin, String target, String[] words, int result) {
        if (begin.equals(target)) {
            answer = result;
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            int change = 0;
            for (int j = 0; j < words[i].length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)){
                    change++;
                }
            }
        
            if (change == words[i].length() - 1 && !visit[i]) {
                visit[i] = true;
                dfs(words[i], target, words, result + 1);
                visit[i] = false;
            }
        }
    }
}