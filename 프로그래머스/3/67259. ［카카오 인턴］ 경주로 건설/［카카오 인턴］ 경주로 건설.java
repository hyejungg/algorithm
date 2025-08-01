import java.util.*;

class Solution {
    static int length;
    static boolean[][][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    static class Pos {
        int x;
        int y;
        int dir; // 방향
        int sum;
        
        Pos(int x, int y, int dir, int sum) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.sum = sum;
        }
    }
    
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        
        length = board.length;
        visited = new boolean[length][length][4];
        
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(0, 0, -1, 0)); 
        
        while(!q.isEmpty()) {
            Pos pos = q.poll();
            
            if (pos.y == length - 1 && pos.x == length -1) {
                answer = Math.min(answer, pos.sum);
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= length || ny >= length || board[nx][ny] == 1)
                    continue;

                int newSum = pos.sum + (pos.dir == -1 || pos.dir == i ? 100 : 600);
                
                if (!visited[nx][ny][i] || board[nx][ny] >= newSum) {
                    visited[nx][ny][i] = true;
                    board[nx][ny] = newSum;
                    q.add(new Pos(nx, ny, i, newSum));
                }
            }
        }
        return answer;    
    }
}