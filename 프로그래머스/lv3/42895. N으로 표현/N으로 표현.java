import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;

        // dp 초기화
        Set<Integer>[] dp = new HashSet[9];
        int n = 0;
        for(int i = 1; i < 9; i++){
            n = (n * 10) + N; // N, NN, NNN, ... 형태로 저장
            dp[i] = new HashSet<>();
            dp[i].add(n);
        }

        for(int i = 1; i <= 8; i++){
            for(int j = 1; j < i; j++){
                for(Integer a : dp[j]){
                    for(Integer b : dp[i - j]){
                        dp[i].add(a + b);
                        dp[i].add(a * b);
                        
                        // 뺄셈은 음수가 나오면 안돼
                        if(a > b)
                            dp[i].add(a - b);
                        if(b > a)
                            dp[i].add(b - a);

                        // 나눗셈은 0으로 나누면 안돼
                        if (b != 0)
                            dp[i].add(a / b);
                        if (a != 0)
                            dp[i].add(b / a);
                    }
                }
            }
            // 존재하면 i (최소 사용 횟수) return
           if(dp[i].contains(number)){
                return i;
            }
            if(i == 8) return -1;
        }
        return -1;
    }
}