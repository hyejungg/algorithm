import java.util.*;

// 점화식 dp[i] = max(dp[i-1], dp[i-2] + sticker[i])

class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        
        if (sticker.length == 1) return sticker[0];
        if (sticker.length == 2) return Math.max(sticker[0], sticker[1]);
        
        int[] dp = new int[sticker.length-1];
        // 0번을 뜯으면 1번과 length-1을 뜯을 수 없음
        dp[0] = sticker[0];
        dp[1] = sticker[0];
        for (int i = 2; i < sticker.length-1; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + sticker[i]);
        }
        
        // 0번을 뜯지 않으면 마지막을 뜯을 수 있음
        int[] dp1 = new int[sticker.length];
        dp1[0] = 0;
        dp1[1] = sticker[1];
        for (int i = 2; i < sticker.length; i++){
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + sticker[i]);
        }
        
        // for (int i = 0; i < dp.length; i++) {
        //     System.out.println(dp[i]);
        // }
        // System.out.println("===========");
        // for (int i = 0; i < dp1.length; i++) {
        //     System.out.println(dp1[i]);
        // }
        
        return Math.max(dp[dp.length-1], dp1[dp1.length-1]);
    }
}