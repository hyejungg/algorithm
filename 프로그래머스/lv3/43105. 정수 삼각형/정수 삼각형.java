import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int[][] temp = new int[triangle.length][triangle.length];
        temp[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            // 맨 왼쪽
            temp[i][0] = temp[i - 1][0] + triangle[i][0];
            // 맨 오른쪽
            temp[i][i] = temp[i - 1][i - 1] + triangle[i][i];
            // 중간 (triangle + 좌우 중 큰 값)
            for (int j = 1; j <= i; j++) {
                temp[i][j] = triangle[i][j] + Math.max(temp[i - 1][j - 1], temp[i - 1][j]);
            }
        }

        // 가장 마지막 줄 합 중 가장 큰 애가 answer
        return Arrays.stream(temp[temp.length - 1]).max().getAsInt();
    }
}