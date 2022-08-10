import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] check = new int[n];
        
        Arrays.fill(check, 1); //우선 1로 채움

        // 잃어버린 애들
        for(int l : lost){
            --check[l - 1];
        }

        // 여벌있는 애들
        for(int r : reserve){
            ++check[r - 1];
        }

        for(int i = 0; i < n; i++){
            if (check[i] == 0) { // 체육복이 없어
                if (i > 0 && check[i - 1] == 2) { // 이전 애가 여벌이 있어
                    --check[i - 1];
                    ++check[i];
                } else if (i < n - 1 && check[i + 1] == 2) { // 디음 애가 여벌이 있어
                    --check[i + 1];
                    ++check[i];
                }
            }
        }
        

        for (int c : check) {
            if(c > 0) answer++;
        }

        return answer;
    }
}