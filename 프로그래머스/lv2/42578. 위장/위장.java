import java.util.*;

class Solution {
    // (x+a)(x+b)(x+c) = x3 + (a+b+c)x2 + (ab+bc+ca)x + (abc)
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>(); // 종류별 개수

        // init
        for (int i = 0; i < clothes.length; i++) {
            // 카테고리가 있으면 +1
            if (map.containsKey(clothes[i][1])) {
                int newCnt = map.get(clothes[i][1]);
                map.put(clothes[i][1], ++newCnt);
            }
            // 카테고리가 없으면 1로 생성
            else {
                map.put(clothes[i][1], 1);
            }
            // map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1); // if-else 안쓰고 한 줄로 갈기는 방법
        }

        // 조합 구해
        for (String key : map.keySet()) {
            answer *= (map.get(key) + 1);
        }

        return --answer;
    }
}