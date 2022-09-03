import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0; // 걸린 시간

        Queue<Integer> q = new LinkedList<>(); // 다리 지나는 트럭 큐
        int sum = 0; // 다리 지나는 트럭 무게 합

        for(int truck : truck_weights) {
            while (true) {
                // 큐 비었으면 트럭 넣어
                if(q.isEmpty()) {
                    q.add(truck);
                    sum += truck;
                    time++;
                    break;
                }
                // 큐 길이 == 다리 길이
                else if (q.size() == bridge_length) {
                    sum -= q.poll();
                }
                // 큐가 안빔
                else {
                    // 최대 무게를 초과
                    if(sum + truck > weight) {
                        q.add(0); //빈 무게 추가
                        time++;
                    }
                    // 최대 무게를 초과하지 않은 경우
                    else  {
                        q.add(truck);
                        sum += truck;
                        time++;
                        break;
                    }
                }
            }
        }
        return time + bridge_length;
    }
}