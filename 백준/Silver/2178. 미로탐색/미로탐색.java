import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int[][] arr;
    static int[][] visit;

    static class Pos {
        int x;
        int y;

        public Pos() {}

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // " "를 기준으로 자르기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visit = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }
        bfs(0, 0, N, M);
//        print(arr);
//        System.out.println("********************");
//        print(visit);
        System.out.println(visit[N - 1][M - 1]);
    }
//    public static void print(int[][] arr) {
//        for(int i = 0; i < arr.length; i++) {
//            for(int j = 0; j < arr[i].length; j++) {
//                System.out.printf(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
    public static void bfs(int start, int end, final int N, final int M) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(start, end));
        visit[start][end] = 1;

        while (!q.isEmpty()) {
            Pos cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)
                    continue;
                if(arr[nextX][nextY] == 1 && visit[nextX][nextY] == 0) {
                    q.add(new Pos(nextX, nextY));
                    visit[nextX][nextY] = visit[cur.x][cur.y] + 1;
                }
            }
        }
    }
}
