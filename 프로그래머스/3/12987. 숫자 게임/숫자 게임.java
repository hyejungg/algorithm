import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        // 오름차순 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        
        int pos = A.length - 1;

        for(int i=A.length - 1; i>=0; i--) {
            if(B[pos] > A[i]) {
                answer++;
                pos--;
            }
        }
        return answer;
    }
}