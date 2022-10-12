import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[] visit; // 방문여부는 해당 노드 하나에 대한 여부니까 배열 1개만
    static StringBuilder str = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // " "를 기준으로 자르기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        visit = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " "); // " "를 기준으로 자르기
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start][end] = 1;
            arr[end][start] = 1;
        }

        System.out.println(dfs(V, N));
        clear(N);
        System.out.println(bfs(V, N));
    }

    public static void clear(final int N) {
        visit = new boolean[N + 1];
        str = new StringBuilder();
    }

    public static String dfs(int start, int N) {
        // 체크인
        visit[start] = true;
        str.append(start + " ");

        // 연결된 곳을 순회
        for (int i = 0; i <= N; i++) {
            // 갈 수 있으면 간다
            if(arr[start][i] == 1 && !visit[i])
                dfs(i, N);
        }
        return str.toString();
    }

    public static String bfs(int start, int N) {
        // 시작점 큐에 넣어
        Queue<Integer> q = new LinkedList<>();
        visit[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            // 큐에서 꺼내
            int cur = q.poll();
            str.append(cur + " ");

            // 연결된 곳을 순회
            for (int i = 1; i <= N; i++) {
                // 갈 수 있으면 간다. 큐에 넣어
                if (arr[cur][i] == 1 && !visit[i]) {
                    visit[i] = true;
                    q.add(i);
                }
            }
        }
        return str.toString();
    }

}
