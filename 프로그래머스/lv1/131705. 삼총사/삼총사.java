import java.util.*;

class Solution {
    public int solution(int[] number) {
        int answer = 0;
        
        // 오름차순 정렬 
        Arrays.sort(number);
        
        for (int i = 0; i < number.length; i++) {
            for (int j = i + 1; j < number.length; j++) {
                for (int k = j + 1; k < number.length; k++) {
                    if (number[i] + number[j] + number[k] == 0) {
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
}