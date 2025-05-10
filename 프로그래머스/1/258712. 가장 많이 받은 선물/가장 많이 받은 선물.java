import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        Map<String, Integer> friendsIdx = new HashMap<>();
        Map<String, Map<String, Integer>> giftMap = new HashMap();
        Map<String, Integer> giftScore = new HashMap<>();
        Map<String, Integer> receivedCount = new HashMap<>();
        
        // 초기 세팅
        for (int i = 0; i < friends.length; i++) {
            friendsIdx.put(friends[i], i);
            giftMap.put(friends[i], new HashMap<>());
            giftScore.put(friends[i], 0);
            receivedCount.put(friends[i], 0);
        }
        
        // 주고 받은 그래프 세팅
        for (String gift : gifts) {
            String[] parts = gift.split(" ");
            String sender = parts[0];
            String receiver = parts[1];
            
            // giftMap 기록
            Map<String, Integer> senderMap = giftMap.get(sender);
            senderMap.put(receiver, senderMap.getOrDefault(receiver, 0) + 1);

            // 선물 지수 갱신
            giftScore.put(sender, giftScore.get(sender) + 1);
            giftScore.put(receiver, giftScore.get(receiver) - 1);
        }
        
        // 다음 달 선물 받을 사람 계산
        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < friends.length; j++) {
                if (i == j) continue;

                String a = friends[i];
                String b = friends[j];

                int aToB = giftMap.get(a).getOrDefault(b, 0);
                int bToA = giftMap.get(b).getOrDefault(a, 0);

                if (aToB > bToA) {
                    receivedCount.put(a, receivedCount.get(a) + 1);
                } else if (aToB == bToA) {
                    if (giftScore.get(a) > giftScore.get(b)) {
                        receivedCount.put(a, receivedCount.get(a) + 1);
                    }
                }
            }
        }
        for (String name : friends) {
            answer = Math.max(answer, receivedCount.get(name));
        }

        return answer;
    }
}