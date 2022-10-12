import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    static int[][] arr;
    static boolean[] visit;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        arr = new int[N + 1][N + 1];
        visit = new boolean[N + 1];
        for (int i = 0; i < M; i++) { // 입력 받는 네트워크 수만큼 돌아
            StringTokenizer str = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(str.nextToken());
            int end = Integer.parseInt(str.nextToken());
            arr[start][end] = arr[end][start] = 1;
        }
        dfs(1, N);
        System.out.println(cnt - 1);
    }

    public static void dfs(int start, final int N) {
        // 체크인 (재방문 금지)
        visit[start] = true;
        cnt++;

        for (int i = 0; i <= N; i++) { // 여기서는 노드를 탐색해야하니까 노드수 만큼 돌아
            if (arr[start][i] == 1 && !visit[i]) {
                dfs(i, N);
            }
        }
    }
}
