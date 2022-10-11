import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        for (String oper : operations) {
            Character command = oper.charAt(0);
            int num = Integer.parseInt(oper.substring(2));
            if (command == 'I') {
                maxPq.add(num);
                minPq.add(num);
            } else if (command == 'D') {// 최소값삭제
                if (num < 0) {
                    if (!maxPq.isEmpty())
                        maxPq.remove(minPq.poll());
                }
                // 최댓값 삭제
                else {
                    if (!minPq.isEmpty())
                        minPq.remove(maxPq.poll());
                }
            }
        }
        
        if (minPq.isEmpty() || maxPq.isEmpty()) 
            return new int[] {0, 0};

        return new int[] {maxPq.peek(), minPq.peek()};
    }
}