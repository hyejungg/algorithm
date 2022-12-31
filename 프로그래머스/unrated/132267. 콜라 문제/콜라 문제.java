import java.util.*;

class Solution {
    public int solution(int a, int b, int n) {
        if (n < a) {
            return 0;
        }
        int answer = (n / a) * b;
        return answer + solution(a, b, answer + (n % a));
    }
}