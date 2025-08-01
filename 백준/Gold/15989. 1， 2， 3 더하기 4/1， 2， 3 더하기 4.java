import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        // dp init 
        int[][] dp = new int[10_001][4]; // 1, 2, 3 조합으로만 더할 수 있음
        dp[1][1] = 1;
        dp[2][1] = 1; dp[2][2] = 1;
        dp[3][1] = 1; dp[3][2] = 1; dp[3][3] = 1;
        
        for (int i = 4; i < 10_001; i++) {
            dp[i][1] = dp[i-1][1]; 
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tc; i++) {
            // 현재 숫자
            int now = Integer.parseInt(br.readLine()); 

            // 현재 숫자의 1, 2, 3의 합을 구하기
            int answer = dp[now][1] + dp[now][2] + dp[now][3];
            sb.append(answer).append("\n");
        }
        
        System.out.print(sb);
        br.close();
    }
}