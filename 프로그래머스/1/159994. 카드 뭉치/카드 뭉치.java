import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int card1Idx = 0;
        int card2Idx = 0;
        
        for (String currentStr : goal) {
            if (card1Idx < cards1.length && currentStr.equals(cards1[card1Idx])) {
                card1Idx++;
            } else if (card2Idx < cards2.length && currentStr.equals(cards2[card2Idx])) {
                card2Idx++;
            } else {
                return "No"; // 둘 다 포함하지 않는 경우
            }
        }
        
        return "Yes";
    }
}