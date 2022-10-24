import java.util.*;

class Solution {
    static List<Integer>[] dp;
    static int _N;
    
    public int solution(int N, int number) {
        int answer = -1;
        
        // 테이블 정의 및 초기값 세팅
        _N = N;
        dp = new ArrayList[10];
        dp[0] = new ArrayList<>();
        dp[0].add(0);
        
        //
        for (int i = 1; i <= 8; i++) {
            dp(i);
            if (dp[i].contains(number)){
                return i;
            }
        }
        
        return answer;
    }
    
    public static List<Integer> dp(int n) {
        if (dp[n] != null) return dp[n];
        
        // 테이블 초기값 세팅
        dp[n] = new ArrayList<>();
        dp[n].add(dp[n - 1].get(0) * 10 + _N);
        
        for (int i = 1; i < n; i++) {
            int j = n - i;
            List<Integer> dp1 = dp(i);
            List<Integer> dp2 = dp(j);
            
            for (int n1 : dp1) {
                for (int n2 : dp2) {
                    dp[n].add(n1 + n2);
                    dp[n].add(n1 - n2);
                    dp[n].add(n1 * n2);
                    if (n2 != 0) dp[n].add(n1 / n2);
                }
            }
        }
        return dp[n];
    }
}