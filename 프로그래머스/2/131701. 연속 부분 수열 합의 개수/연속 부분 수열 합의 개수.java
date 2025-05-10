import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        // 원형 배열이니까 2배 확장
        int n = elements.length;
        int[] extendElem = new int[n * 2];
        for (int i = 0; i < extendElem.length; i++) {
            extendElem[i] = elements[i % n];
        }
        
        Set<Integer> sums = new HashSet<>();
        // 길이가 1짜리부터 시작
        for (int len = 1; len <= n; len++) {
            for (int start = 0; start < n; start++) {
                int sum = 0;
                for (int i = start; i < start + len; i++) {
                    sum += extendElem[i];
                }
                sums.add(sum);
            }
        }
        
        return sums.size();
    }
}