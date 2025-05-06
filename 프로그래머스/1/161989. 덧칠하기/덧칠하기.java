import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        if (m == 1) return section.length;
        
        int answer = 0;
        int current = 0;

        for (int i = 0; i < section.length; i++) {
            if (section[i] > current) {
                // 롤러로 section[i]부터 m 길이만큼 칠함
                current = section[i] + m - 1;
                answer++;
            }
        }
        
        return answer;
    }
}