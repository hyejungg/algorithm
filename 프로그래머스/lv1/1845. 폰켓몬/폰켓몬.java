import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int pickMax = nums.length / 2;
        Set<Integer> pocketmon = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            pocketmon.add(nums[i]);
        }

        return (pocketmon.size() <= pickMax) ? pocketmon.size() : pickMax;
    }
}