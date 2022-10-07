import java.util.*;

class Solution {
    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int dx[] = {1, 0, -1, 0};
    int dy[] = {0, -1, 0, 1};
    int dist[][];
    boolean visit[][];
    public int solution(int[][] maps) {
        int ROW_MAX = maps.length;
        int COL_MAX = maps[0].length;
        dist = new int[ROW_MAX][COL_MAX];
        visit = new boolean[ROW_MAX][COL_MAX];

        int answer = bfs(maps, 0, 0, ROW_MAX, COL_MAX);

        return answer <= 0 ? -1 : answer;
    }
    
    public int bfs(int[][] maps, int start, int end, int ROW_MAX, int COL_MAX) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(start, end));
        visit[start][end] = true;
        dist[start][end] = 1;

        while (!q.isEmpty()) {
            Pos pos = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                if (nx < 0 || nx >= ROW_MAX || ny < 0 || ny >= COL_MAX)
                    continue;

                if(maps[nx][ny] == 1 && !visit[nx][ny]) {
                    dist[nx][ny] = dist[pos.x][pos.y] + 1;
                    q.add(new Pos(nx, ny));
                    visit[nx][ny] = true;
                }
            }
        }
        return dist[ROW_MAX - 1][COL_MAX - 1];
    }
}