import java.util.*;

class Solution {
    private int wallLength;
    private int minFriendsNeeded = Integer.MAX_VALUE;
    
    public int solution(int n, int[] weak, int[] dist) {
        this.wallLength = n;
        
        // dist 내림차순 정렬
		Integer[] reverseDist = Arrays.stream(dist).boxed().toArray(Integer[]::new);
		Arrays.sort(reverseDist, Comparator.reverseOrder());
        
        List<Integer> weakList = new ArrayList<>();
        for (int w : weak) {
            weakList.add(w);
        }
        
        canCover(weakList, 0, reverseDist);
        
        if (minFriendsNeeded == Integer.MAX_VALUE) {
            return -1;
        }
        
        return minFriendsNeeded;
    }
    
    private void canCover(List<Integer> weak, int friendsUsed, Integer[] reverseDist) {
        // 더이상 점검할 취약지점 없는 경우, 지금까지 사용한 친구 수로 갱신
        if (weak.isEmpty()) {
             minFriendsNeeded = Math.min(minFriendsNeeded, friendsUsed);
            return;
        }
        

        // 모든 친구를 다 사용했다면 or 현재까지 사용한 친구 수가 최소 값 이상인 경우
        if (friendsUsed == reverseDist.length || friendsUsed >= minFriendsNeeded) {
            return;
        }

        // 취약점들을 돌면서 찾기
        for (int i = 0; i < weak.size(); i++) {
            int startPoint = weak.get(i);
            int maxCoverIdx = startPoint + reverseDist[friendsUsed];

            List<Integer> nextWeak = new ArrayList<>(weak);
            for (Integer point : weak) {
                if (maxCoverIdx < wallLength) {
                    if (point >= startPoint && point <= maxCoverIdx) {
                        nextWeak.remove(point);
                    }
                } else {
                    int wrappedEnd = maxCoverIdx % wallLength;
                    if (point >= startPoint || point <= wrappedEnd) {
                        nextWeak.remove(point);
                    }
                }
            }

            canCover(nextWeak, friendsUsed + 1, reverseDist);
        }
    }
}