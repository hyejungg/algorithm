import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        int checkDay = startday;
        for (int i = 0; i < schedules.length; i++) {
            int nowScheduleTime = schedules[i];
            int time = getTime(nowScheduleTime);
            
            // 요일별로 통과 가능한지 확인
            int count = 0;
            for (int j = 0; j < 7; j++) {
                // 주말 생략
                if(j == 7-startday || j == 6-startday){
                     continue;
                }
                
                if(6-startday == -1){
                    if(j==6){
                        continue;
                    }
                }
                
                if (time >= timelogs[i][j]) {
                    count++;
                }
            }
            if (count == 5) {
                answer++;
            }   
        }
        
        return answer;
    }
    
    private int getTime(int time) {
        int min = time % 100;
        int hour = time / 100;
        int newMin = min + 10;
        if(newMin >= 60){
            newMin -= 60;
            hour++;
        }
        return hour * 100 + newMin;
    }
}