import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int startNode = -1;
        int doughnut = 0;
        int stick = 0;
        int figure8 = 0;
        
        Map<Integer, Integer> out = new HashMap<>();
        Map<Integer, Integer> in = new HashMap<>();
        
        for (int[] edge : edges) {
            out.put(edge[0], out.getOrDefault(edge[0], 0) + 1);
            in.put(edge[1], in.getOrDefault(edge[1], 0) + 1);
        }
        
        Set<Integer> allNodes = new HashSet<>();
        allNodes.addAll(in.keySet());
        allNodes.addAll(out.keySet());

        for (int node : allNodes) {
            int outCount = out.getOrDefault(node, 0);
            int inCount = in.getOrDefault(node, 0);

            // 시작
            if (inCount == 0 && outCount > 1) {
                startNode = node;
            }else if (inCount >= 1 && outCount == 0) {
                stick++;
            } else if (inCount >= 2 && outCount >= 2) {
                figure8++;
            }
        }

        doughnut = out.get(startNode) - stick - figure8;
        
        return new int[]{startNode, doughnut, stick, figure8 };
    }
}