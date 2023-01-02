import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String X, String Y) {
        Map<String, Integer> xMap = new HashMap<>();
        Map<String, Integer> yMap = new HashMap<>();
        
        List<String> list = new ArrayList<>();
        
        for (String x : X.split("")) {
            xMap.put(x, xMap.getOrDefault(x, 0) + 1);
        }
        
        for (String y : Y.split("")) {
            yMap.put(y, yMap.getOrDefault(y, 0) + 1);
        }
        
        for (String xKey : xMap.keySet()) {
            if (!yMap.containsKey(xKey)) continue;
            
            int length = Math.min(xMap.get(xKey), yMap.get(xKey));
            for (int i = 0; i < length; i++){
                list.add(xKey);
            }
        }
        
        String result = list.stream()
            .sorted(Collections.reverseOrder())
            .collect(Collectors.joining());
        
        if(result.isEmpty()) return "-1";
        if(result.replaceAll("0", "").isEmpty()) return "0";
        return result;
    }
}