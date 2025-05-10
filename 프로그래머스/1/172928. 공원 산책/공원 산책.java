import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        char[][] map = new char[park.length][park[0].length()];

        // 시작점 설정
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                map[i][j] = park[i].charAt(j);
                if (map[i][j] == 'S') {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }

        Map<String, int[]> dmap = new HashMap<>();
        dmap.put("E", new int[]{0, 1});
        dmap.put("W", new int[]{0, -1});
        dmap.put("S", new int[]{1, 0});
        dmap.put("N", new int[]{-1, 0});

        for (String now : routes) {
            String[] parts = now.split(" ");
            String dist = parts[0];
            int step = Integer.parseInt(parts[1]);

            int tempY = answer[0];
            int tempX = answer[1];
            boolean canMove = true;

            int[] d = dmap.get(dist);
            for (int i = 0; i < step; i++) {
                tempY += d[0];
                tempX += d[1];

                if (tempX < 0 || tempX >= map[0].length || tempY < 0 || tempY >= map.length || map[tempY][tempX] == 'X') {
                    canMove = false;
                    break;
                }
            }

            if (canMove) {
                answer[0] = tempY;
                answer[1] = tempX;
            }
        }

        return answer;
    }
}
