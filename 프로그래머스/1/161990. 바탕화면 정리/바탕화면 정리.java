import java.util.*;

class Solution {
    
    static class Pos {
        int x;
        int y;
        
        public void init(int initValue) {
            this.x = initValue;
            this.y = initValue;
        }
    }
    
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        Pos minPos = new Pos();
        Pos maxPos = new Pos();
        minPos.init(Integer.MAX_VALUE);
        maxPos.init(Integer.MIN_VALUE);
        
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    minPos.x = Math.min(minPos.x, j); // 왼쪽
                    minPos.y = Math.min(minPos.y, i); // 위쪽
                    maxPos.x = Math.max(maxPos.x, j); // 오른쪽
                    maxPos.y = Math.max(maxPos.y, i); // 아래쪽
                }
            }
        }

        answer[0] = minPos.y;        // top
        answer[1] = minPos.x;        // left
        answer[2] = maxPos.y + 1;    // bottom (exclusive)
        answer[3] = maxPos.x + 1;    // right (exclusive)

        return answer;
    }
}