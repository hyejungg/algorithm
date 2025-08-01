import java.util.*;

class Solution {
    
    static class Pos {
        int x1, y1, x2, y2;

        Pos(int x1, int y1, int x2, int y2) {
            // 항상 (x1,y1)이 (x2,y2)보다 작도록 정렬
            if (x1 < x2 || (x1 == x2 && y1 <= y2)) {
                this.x1 = x1; this.y1 = y1;
                this.x2 = x2; this.y2 = y2;
            } else {
                this.x1 = x2; this.y1 = y2;
                this.x2 = x1; this.y2 = y1;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Pos)) return false;
            Pos p = (Pos) o;
            return x1 == p.x1 && y1 == p.y1 && x2 == p.x2 && y2 == p.y2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x1, y1, x2, y2);
        }
    }
    
    public int solution(int[][] board) {
        int n = board.length;
        Queue<Pos> queue = new LinkedList<>();
        Set<Pos> visited = new HashSet<>();
        Queue<Integer> time = new LinkedList<>();
        
        // (0,0) (0,1)
        Pos start = new Pos(0, 0, 0, 1);
        queue.offer(start);
        visited.add(start);
        time.offer(0);
        
        while(!queue.isEmpty()) {
            Pos pos = queue.poll();
            int t = time.poll();
            
            
            // 도착 지점에 하나라도 도착했다면 결과 반환
            if ((pos.x1 == n - 1 && pos.y1 == n - 1) || (pos.x2 == n - 1 && pos.y2 == n - 1)) {
                return t;
            }
            
            for (Pos next: getNext(pos, board)) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.offer(next);
                    time.offer(t + 1);
                }
            }
        }
        return -1;
    }
    
    private List<Pos> getNext(Pos p, int[][] board) {
        List<Pos> next = new ArrayList<>();
        int n = board.length;
        
        int[] dx = {-1, 1, 0, 0}; // 상하좌우
        int[] dy = {0, 0, -1, 1};
        
        for (int i = 0; i < 4; i++) {
            int nx1 = p.x1 + dx[i];
            int ny1 = p.y1 + dy[i];
            
            int nx2 = p.x2 + dx[i];
            int ny2 = p.y2 + dy[i];
            
            
            if (inRange(nx1, ny1, n) && inRange(nx2, ny2, n)
                    && board[nx1][ny1] == 0 && board[nx2][ny2] == 0) {
                next.add(new Pos(nx1, ny1, nx2, ny2));
            }
        }
        

        // 회전
        if (p.x1 == p.x2) { // 수평
            for (int d : new int[]{-1, 1}) {
                if (inRange(p.x1 + d, p.y1, n) && inRange(p.x2 + d, p.y2, n)
                        && board[p.x1 + d][p.y1] == 0 && board[p.x2 + d][p.y2] == 0) {
                    next.add(new Pos(p.x1, p.y1, p.x1 + d, p.y1));
                    next.add(new Pos(p.x2, p.y2, p.x2 + d, p.y2));
                }
            }
        } else if (p.y1 == p.y2) { // 수직
            for (int d : new int[]{-1, 1}) {
                if (inRange(p.x1, p.y1 + d, n) && inRange(p.x2, p.y2 + d, n)
                        && board[p.x1][p.y1 + d] == 0 && board[p.x2][p.y2 + d] == 0) {
                    next.add(new Pos(p.x1, p.y1, p.x1, p.y1 + d));
                    next.add(new Pos(p.x2, p.y2, p.x2, p.y2 + d));
                }
            }
        }
        return next;
    }
    
    private boolean inRange(int x, int y, int n) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}