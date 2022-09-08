import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        List<Integer> garo = new ArrayList<>();
        List<Integer> sero = new ArrayList<>();

        for (int i = 0; i < sizes.length; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < sizes[i].length; j++) {
                temp.add(sizes[i][j]);
            }
            int min = Collections.min(temp);
            int max = Collections.max(temp);
            garo.add(min);
            sero.add(max);
        }

        garo.sort(Collections.reverseOrder());
        sero.sort(Collections.reverseOrder());

        return garo.get(0) * sero.get(0);
    }
}