import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0, 0};

        // 1. words를 돈다.
        // 2. n 반복하면서 했던 적이 있나 확인한다

        Map<String, Integer> checks = new HashMap<>();
        checks.put(words[0], 1);
        for (int i = 1; i < words.length; i++) {
            checks.put(words[i], checks.getOrDefault(words[i], 0) + 1);

            // 반복해서 말한 사람 == 탈락자
            // 이전글자의 뒷글자 != 지금글자의 앞글자
            if (checks.get(words[i]) > 1 ||
                words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                int me = i % n + 1;
                int round = i / n + 1;
                answer = new int[]{me, round};
                break;
            }
        }

        return answer;
    }
}