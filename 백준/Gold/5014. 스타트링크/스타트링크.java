import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken()); // F층 짜리 고층 건물
        int S = Integer.parseInt(st.nextToken()); // 강호의 현 위치
        int G = Integer.parseInt(st.nextToken()); // 스타트링크가 있는 층
        int U = Integer.parseInt(st.nextToken()); // 위로 올라가는 버튼
        int D = Integer.parseInt(st.nextToken()); // 아래롣 내려가는 버튼

        int visit[] = new int[F + 1];
        System.out.println(bfs(visit, F, S, G, U, D));
    }

    public static String bfs(int[] visit, int floor, int start, int target, int up, int down) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start); // S 부터 시작 (강호 위치)
        visit[start] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == target) {
                return String.valueOf(visit[now] - 1);
            }

            if (now + up <= floor) {
                if (visit[now + up] == 0) {
                    visit[now + up] = visit[now] + 1;
                    q.add(now + up);
                }
            }

            if (now - down > 0) {
                if (visit[now - down] == 0) {
                    visit[now - down] = visit[now] + 1;
                    q.add(now - down);
                }
            }
        }
        return "use the stairs";
    }
}
