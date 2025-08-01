import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Integer> count = new HashMap<>();
        Map<String, Set<String>> mailList = new HashMap<>();
        Map<String, Integer> userIdx = new HashMap<>();
        
        // 세팅
        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            count.put(id, 0);
            mailList.put(id, new HashSet<>());
            userIdx.put(id, i);
        }
        
        // 중복 제거된 신고만 처리
        Set<String> uniqueReports = new HashSet<>(Arrays.asList(report));
        for (String r : uniqueReports) {
            String[] parts = r.split(" ");
            String from = parts[0]; // 신고한 사람
            String to = parts[1];   // 신고당한 사람

            count.put(to, count.get(to) + 1);
            mailList.get(to).add(from);
        }

        // K 번 신고 당한 유저
        for (String key : count.keySet()) {
            if (count.get(key) >= k) {
                for (String reporter : mailList.get(key)) {
                    int idx = userIdx.get(reporter);
                    answer[idx]++;
                }
            }
        }
        
        return answer;
    }
}