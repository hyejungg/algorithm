import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                // 왼쪽 끝
                if (j == 0)
                    triangle[i][j] += triangle[i - 1][j];
                // 오른쪽 끝
                else if (j == i)
                    triangle[i][j] += triangle[i - 1][j - 1];
                // 중간
                else
                    triangle[i][j] += Math.max(triangle[i - 1][j], triangle[i - 1][j - 1]);
            
            
            // 현재 값 중 가장 큰 값으로 갱신
            answer = Math.max(answer, triangle[i][j]);
            }
        }
        
        return answer;
    }
}