import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};

    static boolean visit[][];
    static int arr[][];
    static int melt[][];

    static class Pos {

        int x;
        int y;

        public Pos() {
        }

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visit = new boolean[N][M];
        melt = new int[N][M]; // 상하좌우가 바다일 때 녹일 양

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0; // 반복횟수
        while (true) {
            int lump = getAreaCnt(N, M);

            if (lump == 0) {
                answer = 0;
                break;
            } else if (lump >= 2) {
                break;
            }
            melting(N, M);
            answer++;
        }
        System.out.println(answer);
    }

    public static int getAreaCnt(int N, int M) {
        int lump = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] > 0 && !visit[i][j]) {
                    dfs(i, j, N, M);
                    lump++;
                }
            }
        }
        return lump;
    }

    public static void dfs(int x, int y, int N, int M) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                continue;
            }
            // 상하좌우가 0일 때 카운팅 -> 녹일 빙산의 양 구하기
            if(arr[nx][ny] == 0)
                melt[x][y]++;

            if (!visit[nx][ny] && arr[nx][ny] > 0) {
                dfs(nx, ny, N, M);
            }
        }
    }

    public static void melting(int N, int M) {
        /**
         * 1. 빙산 녹이기
         * 2. visited 초기화
         * 3. melt 초기화 (년마다 확인해줘야하니까)
         */
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] -= melt[i][j];

                // 빙산의 높이는 음수가 될 수 없음 -> 0으로 바꿔
                if (arr[i][j] < 0)
                    arr[i][j] = 0;

                visit[i][j] = false;
                melt[i][j] = 0;
            }
        }
    }
}
