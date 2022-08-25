import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[] citations) {
        Integer[] newCitation = Arrays.stream(citations).boxed().toArray(Integer[]::new); // 인용 수
        Arrays.sort(newCitation, Collections.reverseOrder()); // 내림차순 정렬(많이 인용된 순으로 정렬)

        for (int i = 0; i < newCitation.length; i++) { // idx == 논문수
            if(newCitation[i] < (i + 1)){ // 인용수 < 논문수 때 h-지수가 정해짐
                return i;
            }
        }

        return newCitation.length;
    }
    // 문제 이해 못해서 H-지수가 뭔가 쳐봄; https://www.ibric.org/myboard/read.php?Board=news&id=270333
}