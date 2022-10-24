import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[301];

        for (int i = 1; i <= N; i++) {
            int score = Integer.parseInt(br.readLine());
            scores[i] = score;
        }
        
        // 예외처리 필요
        if (N == 1){
            System.out.println(scores[1]);
            return;
        }

        int[][] dp = new int[301][3]; // 최대 계단의 수가 300, 1/2번째 index만 쓸꺼라 3
        
        dp[1][1] = scores[1];
        dp[1][2] = 0;
        dp[2][1] = scores[2];
        dp[2][2] = scores[1] + scores[2];
        for (int i = 3; i <= N; i++) {
            dp[i][1] = Math.max(dp[i-2][1], dp[i-2][2]) + scores[i];
            dp[i][2] = dp[i-1][1] + scores[i];
        }
        System.out.println(Math.max(dp[N][1], dp[N][2]));
    }
}
