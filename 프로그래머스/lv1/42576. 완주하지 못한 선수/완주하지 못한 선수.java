import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        for (String c : completion) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            }
        }

        String answer = map.entrySet().stream()
            .filter(person -> person.getValue() != 0)
            .map(person -> person.getKey())
            .collect(Collectors.joining());

        return answer;
    }
}