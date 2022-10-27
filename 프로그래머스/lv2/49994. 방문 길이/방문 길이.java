import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> set = new HashSet<>(); // 경로를 저장할 set
        
        int x = 0;
        int y = 0;
        
        for (int i = 0; i < dirs.length(); i++) {
            String route = "";
            int nx = x;
            int ny = y;
            
            if (dirs.charAt(i) == 'U') { // 현재 좌표 이동 좌표
                ny++;
                route += x;
                route += y;
                route += nx;
                route += ny;
            } else if (dirs.charAt(i) == 'D') { // 이동 좌표 현재 좌표
                ny--;
                route += nx;
                route += ny;
                route += x;
                route += y;
            } else if (dirs.charAt(i) == 'R') { // 현재 좌표 이동 좌표
                nx++;
                route += x;
                route += y;
                route += nx;
                route += ny;
            } else if (dirs.charAt(i) == 'L') { // 이동 좌표 현재 좌표
                nx--;
                route += nx;
                route += ny;
                route += x;
                route += y;
            }
            
            // 경로가 범위 밖이면 넘어가
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;
            
            set.add(route);
            
            // 초기화
            x = nx;
            y = ny;
        }
        
        return set.size();
    }
}