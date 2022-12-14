import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};

    static int dist[]; // 걸린 시간

    static int cnt = 0;
    static int time = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        if (N >= K){
            System.out.println((N - K));
            System.out.println(1);
            return;
        }
        
        dist = new int[100001];

        bfs(N, K);

        System.out.println(time);
        System.out.println(cnt);
    }

    public static void bfs(int start, int target) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            // now 방문 시간이 최소 시간보다 크다면 나가
            if (time < dist[now]) return;
            
            // 이동 가능한 모든 경우의 수를 구함
            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0)
                    next = now - 1;
                else if (i == 1)
                    next = now + 1;
                else
                    next = now * 2;

                if (next < 0 || next >= dist.length) continue;
                
                if (next == target) {
                    time = dist[now];
                    cnt++;
                    break;
                }

                if (dist[next] == 0 || dist[next] == dist[now] + 1) {
                    q.add(next);
                    dist[next] = dist[now] + 1;
                }
            }
        }
    }
}
