import java.util.*;

class Solution {
    static int answer;
    static int[] nums;
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        
        // 입력 가능한 정수 값들 세팅
        nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        
        // 조합 찾기
        comb(n, q, ans, 0, new ArrayList<>());
        
        return answer;
    }
    
    // 백트래킹해서 가능한 모든 조합 찾기
    public void comb(int n, int[][] q, int[] ans, int cur, List<Integer> list) {
        if(list.size() == 5) {
            if(isPossible(q, ans, list)) answer++;
            return;
        }
        
        for(int i=cur; i<n; i++) {
            list.add(nums[i]);
            comb(n, q, ans, i+1, list);
            list.remove(list.size() - 1);
        }
    }
    
    public boolean isPossible(int[][] q, int[] ans, List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        for (int i = 0; i < q.length; i++) {
            int cnt = 0;
            for (int j = 0; j < q[i].length; j++){
                if (set.contains(q[i][j])) {
                    cnt++;
                }
            }
            if (cnt != ans[i]) {
                return false;
            }
        }
        return true;
    }
}