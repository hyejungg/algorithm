import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim(); // 암호화된 숫자
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // 0번째는 1로 초기화
        dp[1] = 1;

        // 첫 글자가 '0'이면 해석 불가능
        if (s.charAt(0) == '0') {
            System.out.println(0);
            return;
        }
        
        for (int i = 2; i <= n; i++) {
            char curr = s.charAt(i - 1);
            char prev = s.charAt(i - 2);

            // 한 자리 수 해석 가능 (1~9)
            if (curr != '0') {
                dp[i] += dp[i - 1];
                dp[i] %= 1000000;
            }

            // 두 자리 수 해석 가능 (10~26)
            int twoDigit = (prev - '0') * 10 + (curr - '0');
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
                dp[i] %= 1000000;
            }
        }

        System.out.println(dp[n]);
    }
}
