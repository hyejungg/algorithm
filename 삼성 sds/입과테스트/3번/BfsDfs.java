import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static Character[][] arr;
    static int[][] dist;

    static class Pos {
        int x;
        int y;

        public Pos() {}
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder str = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            arr = new Character[N][M];
            for (int r = 0; r < N; r++) {
                String line = br.readLine();
                for (int c = 0; c < line.length(); c++) {
                    arr[r][c] = line.charAt(c);
                }
            }

            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                arr[r-1][c-1] = '!';
            }

            int answer = Integer.MAX_VALUE; // 각 점에 대해 최소 거리를 구해야 해
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if ((arr[r][c] == '.' || arr[r][c] == '!')) {
                        dist = new int[N][M];
                        int count = bfs(r, c, N, M, K);
                        answer = Math.min(answer, count);
                    }
                }
            }

            if (answer == Integer.MAX_VALUE) answer = -1;
            str.append('#').append(i).append(' ').append(answer).append('\n');
        }
        bw.write(str.toString());
        bw.newLine();
        br.close();
        bw.flush();
        bw.close();
    }

    public static void print(int[][] dist) {
        System.out.println("*********************");
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[i].length; j++) {
                System.out.printf(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int bfs(int x, int y, int N, int M, int K) {
        int fireCount = 0;
        if (arr[x][y] == '!') fireCount++;
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(x, y));
        dist[x][y] = 1;

        int maxDist = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            Pos now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (fireCount == K) return maxDist - 1;

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if (dist[nx][ny] == 0 && (arr[nx][ny] == '.' || arr[nx][ny] == '!')) {
                    if (arr[nx][ny] == '!') fireCount++;
                    q.add(new Pos(nx, ny));
                    dist[nx][ny] = dist[now.x][now.y] + 1;
                    maxDist = Math.max(maxDist, dist[nx][ny]);
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
