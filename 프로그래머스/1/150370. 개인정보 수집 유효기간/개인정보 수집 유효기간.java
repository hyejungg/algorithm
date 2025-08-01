import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter; // 이거 import 안하면 DateTimeFormatter 못가져옴

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> termsMap = new HashMap<>();
        
        for (String term : terms) {
            String[] parts = term.split(" ");
            termsMap.put(parts[0], Integer.parseInt(parts[1]));
        }
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate todayDate = LocalDate.parse(today, formatter);
        
        for (int i = 0; i < privacies.length; i++) {
            String[] parts = privacies[i].split(" ");
            LocalDate date = LocalDate.parse(parts[0], formatter);
            int termMonths = termsMap.get(parts[1]);

            date = date.plusMonths(termMonths);

            if (todayDate.isAfter(date) || todayDate.isEqual(date)) {
                answer.add(i + 1);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}