import java.util.*;
import java.util.stream.Collectors;

class Solution {
    private Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        char[] nums = numbers.toCharArray(); // 순열을 만들 배열
        char[] output = new char[nums.length]; // 순열 배열
        boolean[] visited = new boolean[nums.length]; // 중복 저장 안하기 위한 방문 여부 확인

        for (int i  = 1; i <= numbers.length(); i++) {
            permutation(nums, output, visited, 0, nums.length, i);
        }
        
        return set.stream().filter(this::isPrime).collect(Collectors.toList()).size();
    }
    
    private boolean isPrime(int n) {
        //1보다 크면서 1과 자기자신만 약수를 갖는 수 == 소수
        if(n == 1 || n == 0) return false;
        if(n < 2) return false;

        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    private void permutation(char[] nums, char[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            StringBuilder number = new StringBuilder();
            for (int i = 0; i < r; i++) {
                number.append(output[i]);
            }
            set.add(Integer.parseInt(number.toString()));
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = nums[i];
                permutation(nums, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }
}