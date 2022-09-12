import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        // 일단 리스트에 한글자씩 넣어
        List<Integer> num = new ArrayList<>();
        for (int i = 0; i < number.length(); i++) {
            num.add(Integer.parseInt(String.valueOf(number.charAt(i))));
        }

        // length - k 만큼 탐색해
        int startIdx = 0;
        for (int i = 0; i < number.length() - k; i++) {
            int maxValue = num.get(startIdx);
            int idx = startIdx;
            for (int j = startIdx; j <= i + k; j++) {
                if (num.get(j) > maxValue) {
                    maxValue = num.get(j);
                    idx = j;
                }
            }
            startIdx = idx + 1;
            answer.append(maxValue);
        }
        return answer.toString();
    }
}