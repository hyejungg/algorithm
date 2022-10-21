import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[301];
        int total = 0;

        for (int i = 1; i <= N; i++) {
            int score = Integer.parseInt(br.readLine());
            total += score;
            scores[i] = score;
        }

        // 예외처리 필요
        if (N == 1){
            System.out.println(total);
            return;
        }

        int[] dp = new int[301]; // 최대 계단의 수가 300
        dp[1] = scores[1];
        dp[2] = scores[2];
        dp[3] = scores[3];
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.min(dp[i-2], dp[i-3]) + scores[i];
        }
        // 마지막 도착 계단은 밟아야 해 (모든 계단의 합)
        // 가장 마지막으로 선택될 밟지 않은 계단은 N-1번째거나 N-2번쨰야
        System.out.println(total - Math.min(dp[N-1], dp[N-2]));
    }
}
