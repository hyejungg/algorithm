import java.util.*;
import java.util.stream.*;

class Solution {
    int[] parents;
    public int solution(int n, int[][] costs) {
        int selected = 0;
        int answer = 0;
        
        // 부모 배열 할당
        parents = new int[n];
        for(int i = 0; i < n; i++) {
            parents[i] = i;
        }
        
        // 간선이 낮은 순으로 정렬
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        
        for (int i = 0; i < costs.length; i++) {
            // 부모 같은지 확인해
            if (find(costs[i][0]) != find(costs[i][1])) {
                selected++; // n-1개 확인을 위함
                union(costs[i][0], costs[i][1]);
                answer += costs[i][2];
            }
            if (selected == n - 1) break;
        }
        
        return answer;
    }
    
    private void union(int x, int y) {
        x = find(x);
        y = find(y);
        // 집합 중 가장 작은 값으로 루트 노드 해줘
        if (x > y) parents[x] = y;
        else parents[y] = x;
    }
    
    // 부모를 찾아요
    private int find(int x) {
        if (parents[x] == x) return x;
        return find(parents[x]);
    }
}