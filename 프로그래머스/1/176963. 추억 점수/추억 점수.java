import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> score = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            score.put(name[i], yearning[i]);
        }
        
        for(String[] list : photo) {
            int number = 0;
            for (String user : list) {
                if (score.containsKey(user)) {
                    number += score.get(user);
                }
            }
            answer.add(number);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}