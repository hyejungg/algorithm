import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dist = new int[100001];

        if (N == K) {
            System.out.println(0);
        } else {
            bfs(N, K);
        }
    }

    public static void bfs (int N, int K) {
        Queue<Integer> q = new LinkedList<>();
        q.add(N); // N 부터 시작
        dist[N] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            // 3가지 경우의 수
            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0)
                    next = now - 1;
                else if (i == 1)
                    next = now + 1;
                else
                    next = now * 2;

                if (next == K) {
                    System.out.println(dist[now]);
                    return;
                }

                if (next < 0 || next >= dist.length) continue;

                if (dist[next] == 0) {
                    q.add(next);
                    dist[next] = dist[now] + 1;
                }
            }
        }
    }
}
