class Solution {
    int answer = 0;

    public void dfs(int[] numbers, int target, int sum, int idx){
        if(idx == numbers.length){ // 배열 끝까지 돌았을 때
            if(sum == target){
                ++answer;
            }
            return;
        }
        dfs(numbers, target, sum + numbers[idx], idx + 1); // + 인 경우
        dfs(numbers, target, sum - numbers[idx], idx + 1); // - 인 경우
    }

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);

        return answer;
    }
}