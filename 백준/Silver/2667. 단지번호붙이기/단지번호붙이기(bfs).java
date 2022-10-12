import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static class Pos {
        int x;
        int y;

        public Pos() {}
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] arr;
    static boolean[][] visit;
    static int[] cnts;

    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visit = new boolean[N][N];
        cnts = new int[N * N]; // 김혜정 ..... 지도의 전체 크기는 n * n이잔슴 .......
        int num = 0;

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        // 섬문제는 모든 점이 시작점!
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && !visit[i][j]) {
                    num++;
                    bfs(i, j, num, N);
                }
            }
        }

        Arrays.sort(cnts); // 오름차순 정렬
        System.out.println(num);
        for (int i = 0; i < cnts.length; i++) {
            if (cnts[i] != 0)
                System.out.println(cnts[i]);
        }
    }

//    public static void print() {
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr.length; j++) {
//                System.out.printf(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }

    public static void bfs(int start, int end, final int area, final int N) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(start, end));
        arr[start][end] = area;
        visit[start][end] = true;
        cnts[area]++;

        while (!q.isEmpty()) {
            Pos pos = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = pos.x + dx[i];
                int nextY = pos.y + dy[i];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N)
                    continue;
                if (arr[nextX][nextY] == 1 && !visit[nextX][nextY]) {
                    q.add(new Pos(nextX, nextY));
                    visit[nextX][nextY] = true;
                    arr[nextX][nextY] = area;
                    cnts[area]++;
                }
            }
        }

    }
}
