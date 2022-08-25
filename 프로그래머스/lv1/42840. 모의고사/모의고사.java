import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] answers) {
        int[] score = new int[]{0, 0, 0};

        // 수포자 123 정의
        final int[] one = new int[]{1, 2, 3, 4, 5};
        final int[] two = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        final int[] three = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for (int i = 0; i < answers.length; i++) {
            if(one[i % 5] == answers[i])
                score[0]++;
            if(two[i % 8] == answers[i])
                score[1]++;
            if(three[i % 10] == answers[i])
                score[2]++;
        }

        int maxScore = Arrays.stream(score).max().getAsInt();
        
        return IntStream.range(0, 3).filter(i -> score[i] == maxScore).map(i -> i + 1).sorted().toArray();
    }
}