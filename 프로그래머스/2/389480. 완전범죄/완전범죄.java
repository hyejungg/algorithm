import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        final int INF = 1_000_000_000;

        // dp[bSum] = B 흔적 합이 bSum일 때 가능한 A 흔적의 최소값
        int[] dp = new int[m];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int[] now : info) {
            int a = now[0];
            int b = now[1];

            int[] next = new int[m];
            Arrays.fill(next, INF);

            for (int bSum = 0; bSum < m; bSum++) {
                if (dp[bSum] == INF) continue;

                // 1) A가 훔침: A 흔적 +a, B 흔적 그대로
                int aSum = dp[bSum] + a;
                if (aSum < n) {
                    next[bSum] = Math.min(next[bSum], aSum);
                }

                // 2) B가 훔침: A 흔적 그대로, B 흔적 +b (인덱스 이동)
                int nb = bSum + b;
                if (nb < m) {
                    next[nb] = Math.min(next[nb], dp[bSum]);
                }
            }

            dp = next;
        }

        int answer = INF;
        for (int bSum = 0; bSum < m; bSum++) {
            answer = Math.min(answer, dp[bSum]);
        }

        return (answer == INF) ? -1 : answer;
    }
}
