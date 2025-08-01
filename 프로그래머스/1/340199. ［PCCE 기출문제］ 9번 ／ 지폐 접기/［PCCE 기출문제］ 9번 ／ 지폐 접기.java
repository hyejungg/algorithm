import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        while (true) {
            int walletMin = Math.min(wallet[0], wallet[1]);
            int walletMax = Math.max(wallet[0], wallet[1]);
            
            int billMin = Math.min(bill[0], bill[1]);
            int billMax = Math.max(bill[0], bill[1]);
            
            if (billMin > walletMin || billMax > walletMax) {
                if (bill[0] > bill[1]) {
                    bill[0] = bill[0] / 2;
                } else {
                    bill[1] = bill[1] / 2;
                }
                answer++;
            } else {
                break;
            }
        }
        return answer;
    }
}