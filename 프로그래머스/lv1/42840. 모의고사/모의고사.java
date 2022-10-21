import java.util.*;
import java.util.stream.*;

class Solution {
    static int[] one = new int[] {1, 2, 3, 4, 5};
    static int[] two = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
    static int[] three = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {
        int[] ans = new int[3];
    
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == one[i % one.length]) ans[0]++;
            if (answers[i] == two[i % two.length]) ans[1]++;
            if (answers[i] == three[i % three.length]) ans[2]++;
        }
        
        int maxCnt = Arrays.stream(ans).max().getAsInt();
        int[] answer = IntStream.range(0, 3).filter(i -> ans[i] == maxCnt).map(i -> i + 1).sorted().toArray();
        
        return answer;
    }
}