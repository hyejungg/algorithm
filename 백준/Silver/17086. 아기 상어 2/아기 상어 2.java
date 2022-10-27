import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    static int dx[] = {1, 0, -1, 0, 1, 1, -1, -1, };
    static int dy[] = {0, 1, 0, -1, -1, 1, -1, 1, };

    static int N, M;
    static int[][] arr, dist;

    static class Pos {
        int x;
        int y;

        public Pos(){}
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 각 점에 대하여 최소 안전 거리를 구해야 해
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    init();
                    int cnt = bfs(i, j);
                    answer = Math.max(cnt, answer);
                 }
            }
        }
        System.out.println(answer);
    }

    /**
     *  dist는 -1로 초기화
     *  이걸로 visit 처럼 씀. 왜냐 -1이 아니면 방문한 애들이니까
     */
    public static void init() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dist[i][j] = -1;
            }
        }
    }

    public static int bfs(int x, int y) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(x, y));
        dist[x][y] = 0;

        while (!q.isEmpty()) {
            Pos now = q.poll();

            for (int i = 0; i < 8; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if (arr[nx][ny] == 1) {
                    return dist[now.x][now.y] + 1;
                }

                if (dist[nx][ny] == -1 && arr[nx][ny] == 0) {
                    q.add(new Pos(nx, ny));
                    dist[nx][ny] = dist[now.x][now.y] + 1;
                }
            }
        }
        return 0;
    }
}
