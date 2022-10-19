import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // 전체 격자 개수 만큼 반복
        for (int i = 1; i <= (brown + yellow); i++) {
            int sero = i;
            int garo = (brown + yellow) / sero;
            
            // 카펫의 가로 길이는 세로 길이와 같거나 길다
            if (sero > garo) 
                continue; 
            
            // (sero - 2) * (garo - 2) == yellow
            if ((sero - 2) * (garo - 2) == yellow) {
                answer[0] = garo;
                answer[1] = sero;
                return answer;
            }
        }
        
        return answer;
    }
}